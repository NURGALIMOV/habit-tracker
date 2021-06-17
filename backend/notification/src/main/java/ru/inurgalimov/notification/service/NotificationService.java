package ru.inurgalimov.notification.service;

import ru.inurgalimov.notification.dto.Message;

public interface NotificationService {

    void notify(Message message);

}
