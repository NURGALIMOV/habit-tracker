package ru.inurgalimov.habit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.inurgalimov.habit.api.NotificationApi;
import ru.inurgalimov.habit.dto.Notification;
import ru.inurgalimov.habit.service.NotificationService;
import ru.inurgalimov.habit.util.HabitUtils;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class NotificationController implements NotificationApi {

    private final NotificationService service;

    @Override
    public UUID create(Notification notification, String profile) {
        return service.create(notification, HabitUtils.getUserId(profile));
    }

    @Override
    public Notification update(Notification notification, String profile) {
        return service.update(notification, HabitUtils.getUserId(profile));
    }

    @Override
    public void delete(UUID notificationId, String profile) {
        service.delete(notificationId, HabitUtils.getUserId(profile));
    }

}
