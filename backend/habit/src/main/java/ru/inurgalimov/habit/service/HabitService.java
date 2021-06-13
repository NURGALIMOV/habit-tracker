package ru.inurgalimov.habit.service;

import ru.inurgalimov.habit.dto.Habit;

import java.util.List;
import java.util.UUID;

public interface HabitService {

    List<Habit> getAllHabits(UUID userId);

    Habit getHabit(UUID uuid);

    UUID createHabit(Habit habit);

    void update(Habit habit);

    void delete(UUID uuid);

}
