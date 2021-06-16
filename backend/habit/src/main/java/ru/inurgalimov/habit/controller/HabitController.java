package ru.inurgalimov.habit.controller;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import ru.inurgalimov.habit.api.HabitApi;
import ru.inurgalimov.habit.dto.Habit;
import ru.inurgalimov.habit.service.HabitService;
import ru.inurgalimov.habit.util.HabitUtils;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class HabitController implements HabitApi {

    private final HabitService service;

    @Override
    public List<Habit> getAll(String profile) {
        return service.getAllHabits(HabitUtils.getUserId(profile));
    }

    @Override
    public Habit get(UUID habitId, String profile) {
        return service.getHabit(habitId, HabitUtils.getUserId(profile));
    }

    @Override
    public UUID create(Habit habit, String profile) {
        return service.createHabit(habit, HabitUtils.getUserId(profile));
    }

    @Override
    public void update(Habit habit, String profile) {
        service.update(habit, HabitUtils.getUserId(profile));
    }

    @Override
    public void delete(UUID habitId, String profile) {
        service.delete(habitId, HabitUtils.getUserId(profile));
    }

}
