package ru.inurgalimov.habit.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inurgalimov.habit.dto.Notification;
import ru.inurgalimov.habit.entity.NotificationEntity;
import ru.inurgalimov.habit.mapper.NotificationMapper;
import ru.inurgalimov.habit.repository.NotificationRepository;
import ru.inurgalimov.habit.service.NotificationService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;
    private final NotificationMapper mapper;

    @Override
    public UUID create(Notification notification) {
        return repository.save(mapper.toEntityWithHabit(notification)).getId();
    }

    @Override
    public Notification update(Notification notification) {
        NotificationEntity entity = repository.save(mapper.toEntityWithHabit(notification));
        return mapper.toDto(entity);
    }

    @Override
    public void delete(UUID notificationId) {
        repository.deleteById(notificationId);
    }

}
