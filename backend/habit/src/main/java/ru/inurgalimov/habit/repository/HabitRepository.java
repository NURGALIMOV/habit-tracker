package ru.inurgalimov.habit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inurgalimov.habit.entity.HabitEntity;

import java.util.UUID;

public interface HabitRepository extends JpaRepository<HabitEntity, UUID> {
}
