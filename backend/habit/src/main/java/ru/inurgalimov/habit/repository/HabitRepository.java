package ru.inurgalimov.habit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.inurgalimov.habit.entity.HabitEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HabitRepository extends JpaRepository<HabitEntity, UUID> {

    @Transactional
    Optional<HabitEntity> findByIdAndUserId(UUID uuid, UUID userId);

    @Transactional
    List<HabitEntity> findAllByUserId(UUID userId);

}
