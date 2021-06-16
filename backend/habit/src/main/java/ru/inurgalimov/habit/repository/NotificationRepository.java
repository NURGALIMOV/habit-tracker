package ru.inurgalimov.habit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.inurgalimov.habit.entity.NotificationEntity;

import java.util.Optional;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<NotificationEntity, UUID> {

    @Transactional
    Optional<NotificationEntity> findByIdAndUserId(UUID uuid, UUID userId);
}
