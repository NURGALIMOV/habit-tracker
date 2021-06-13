package ru.inurgalimov.habit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inurgalimov.habit.entity.ProgressEntity;

import java.util.UUID;

public interface ProgressRepository extends JpaRepository<ProgressEntity, UUID> {
}
