package ru.inurgalimov.habit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inurgalimov.habit.api.HabitApi;
import ru.inurgalimov.habit.dto.Habit;
import ru.inurgalimov.habit.dto.Message;
import ru.inurgalimov.habit.service.HabitService;
import ru.inurgalimov.habit.util.HabitUtils;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class HabitController implements HabitApi {

    private final HabitService service;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public List<Habit> getAll(String profile) {
        return service.getAllHabits(HabitUtils.getUserId(profile));
    }

    @Override
    public Habit get(UUID habitId, String profile) {
        return service.getHabit(habitId, HabitUtils.getUserId(profile));
    }

    @Override
    public UUID create(Habit habit, String profile) {
        return service.createHabit(habit, HabitUtils.getUserId(profile));
    }

    @Override
    public void update(Habit habit, String profile) {
        service.update(habit, HabitUtils.getUserId(profile));
    }

    @Override
    public void delete(UUID habitId, String profile) {
        service.delete(habitId, HabitUtils.getUserId(profile));
    }

    // TODO убрать
    @GetMapping(value = "/nnn", produces = APPLICATION_JSON_VALUE)
    public void getNNN() {
        for (int i = 1; i < 10; i++) {
            rabbitTemplate.convertAndSend("notifications", Message.builder()
                    .email("email")
                    .heading("heading")
                    .text("text")
                    .build(),
                    m -> {
                        m.getMessageProperties().getHeaders().put("__TypeId__", "ru.inurgalimov.notification.dto.Message");
                        return m;
                    });
        }
        System.out.println("END");
    }

}
