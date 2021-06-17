package ru.inurgalimov.notification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.inurgalimov.notification.api.NotificationApi;
import ru.inurgalimov.notification.dto.Message;
import ru.inurgalimov.notification.service.NotificationService;

@RequiredArgsConstructor
@RestController
public class NotificationEmailController implements NotificationApi {

    private final NotificationService notificationService;

    @Override
    public void notify(Message message) {
        notificationService.notify(message);
    }

}
