package ru.inurgalimov.habit.service;

import ru.inurgalimov.habit.dto.Habit;

import java.util.List;
import java.util.UUID;

public interface HabitService {

    List<Habit> getAllHabits(UUID userId);

    Habit getHabit(UUID uuid, UUID userId);

    UUID createHabit(Habit habit, UUID userId);

    void update(Habit habit, UUID userId);

    void delete(UUID uuid, UUID userId);

}
