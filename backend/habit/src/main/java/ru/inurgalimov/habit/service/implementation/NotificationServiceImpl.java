package ru.inurgalimov.habit.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inurgalimov.habit.dto.Notification;
import ru.inurgalimov.habit.entity.NotificationEntity;
import ru.inurgalimov.habit.exception.HabitException;
import ru.inurgalimov.habit.exception.NotFoundException;
import ru.inurgalimov.habit.mapper.NotificationMapper;
import ru.inurgalimov.habit.repository.NotificationRepository;
import ru.inurgalimov.habit.service.NotificationService;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;
    private final NotificationMapper mapper;

    @Override
    public UUID create(Notification notification, UUID userId) {
        notification.setUserId(userId);
        return repository.save(mapper.toEntityWithHabit(notification)).getId();
    }

    @Override
    public Notification update(Notification notification, UUID userId) {
        if (Objects.isNull(notification) || Objects.isNull(notification.getId())) {
            throw new HabitException();
        }
        if (repository.findByIdAndUserId(notification.getId(), userId).isPresent()) {
            NotificationEntity entity = repository.save(mapper.toEntityWithHabit(notification));
            return mapper.toDto(entity);
        }
        throw new NotFoundException("Not found notification for current user");
    }

    @Override
    public void delete(UUID notificationId, UUID userId) {
        if (repository.findByIdAndUserId(notificationId, userId).isPresent()) {
            repository.deleteById(notificationId);
            return;
        }
        throw new NotFoundException("Not found notification for current user");
    }

}
