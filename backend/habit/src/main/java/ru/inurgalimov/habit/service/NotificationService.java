package ru.inurgalimov.habit.service;

import ru.inurgalimov.habit.dto.Notification;

import java.util.UUID;

public interface NotificationService {

    UUID create(Notification notification);

    Notification update(Notification notification);

    void delete(UUID notificationId);

}
