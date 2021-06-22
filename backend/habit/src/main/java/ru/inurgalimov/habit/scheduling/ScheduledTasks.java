package ru.inurgalimov.habit.scheduling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.inurgalimov.habit.dto.Habit;
import ru.inurgalimov.habit.dto.Message;
import ru.inurgalimov.habit.dto.Progress;
import ru.inurgalimov.habit.service.HabitService;
import ru.inurgalimov.habit.service.ProgressService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduledTasks {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final int COMPLETE_COUNT = 66;
    private final HabitService habitService;
    private final ProgressService progressService;
    private final RabbitTemplate rabbitTemplate;

    @Scheduled(cron = "0 1 0 * * ?")
    public void scheduleTaskForAutomaticCreateProgress() {
        log.info("Cron Task(scheduleTaskForAutomaticCreateProgress) start :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        var currentDate = LocalDate.now();
        habitService.getAllHabits()
                .stream()
                .filter(habit -> habit.getProgress().stream()
                        .noneMatch(progress -> progress.getCreateDate().isEqual(currentDate.minusDays(1))))
                .forEach(habit -> progressService.createProgress(Progress.builder()
                        .status(false)
                        .description("Fill automatic")
                        .habitId(habit.getId())
                        .createDate(currentDate.minusDays(1))
                        .build()));
        log.info("Cron Task(scheduleTaskForAutomaticCreateProgress) finish :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void scheduleTaskForCompleteHabit() {
        log.info("Cron Task(scheduleTaskForCompleteHabit) start :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        habitService.getAllHabits()
                .stream()
                .filter(habit -> habit.getProgress().stream().filter(Progress::getStatus).count() == COMPLETE_COUNT)
                .forEach(habit -> {
                    habit.setIsActive(false);
                    habitService.update(habit, habit.getUserId());
                    rabbitTemplate.convertAndSend("notifications", Message.builder()
                                    .email(habit.getNotifies().get(0).getEmail())
                                    .heading("Complete")
                                    .text("Congratulations you have acquired a new habit.")
                                    .build(),
                            m -> {
                                m.getMessageProperties().getHeaders().put("__TypeId__", "ru.inurgalimov.notification.dto.Message");
                                return m;
                            });
                });
        log.info("Cron Task(scheduleTaskForCompleteHabit) finish :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }

    // TODO Rework ThreadPoolTaskScheduler
    @Scheduled(fixedRate = 3_600_000)
    public void scheduleTaskNotifyUser() {
        log.info("Cron Task(scheduleTaskNotifyUser) start :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        var currentTime = LocalTime.now();
        habitService.getAllHabits().stream()
                .map(Habit::getNotifies)
                .flatMap(Collection::stream)
                .filter(notification -> {
                    final var notificationTime = notification.getNotificationTime();
                    return notificationTime.isBefore(currentTime) && notificationTime.isAfter(currentTime.minusHours(1));
                })
                .forEach(notification -> rabbitTemplate.convertAndSend("notifications", Message.builder()
                                .email(notification.getEmail())
                                .heading("Reminder")
                                .text("Don't forget about the habit.")
                                .build(),
                        m -> {
                    m.getMessageProperties().getHeaders().put("__TypeId__", "ru.inurgalimov.notification.dto.Message");
                    return m;
                }));
        log.info("Cron Task(scheduleTaskNotifyUser) finish :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }

}
