package ru.inurgalimov.habit.service;

import ru.inurgalimov.habit.dto.Habit;
import ru.inurgalimov.habit.dto.HabitResponse;

import java.util.List;
import java.util.UUID;

public interface HabitService {

    List<HabitResponse> getAllHabits(UUID userId);

    List<HabitResponse> getAllHabits();

    HabitResponse getHabit(UUID uuid, UUID userId);

    UUID createHabit(Habit habit, UUID userId);

    void update(Habit habit, UUID userId);

    void delete(UUID uuid, UUID userId);

}
