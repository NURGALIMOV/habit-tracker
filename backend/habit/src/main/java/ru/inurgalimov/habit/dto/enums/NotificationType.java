package ru.inurgalimov.habit.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationType {

    EMAIL("Уведомление по почте");

    private final String description;

}
