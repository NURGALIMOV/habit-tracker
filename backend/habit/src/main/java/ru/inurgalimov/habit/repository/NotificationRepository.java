package ru.inurgalimov.habit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inurgalimov.habit.entity.NotificationEntity;

import java.util.UUID;

public interface NotificationRepository extends JpaRepository<NotificationEntity, UUID> {
}
