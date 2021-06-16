package ru.inurgalimov.habit.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.inurgalimov.habit.dto.enums.NotificationType;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity(name = "Notification")
@Data
@EqualsAndHashCode(callSuper = true)
public class NotificationEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    @Column
    private LocalTime notificationTime = LocalTime.of(18, 0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habit_id")
    private HabitEntity habit;

    private String email;

    @Column(nullable = false, updatable = false)
    private UUID userId;

}
