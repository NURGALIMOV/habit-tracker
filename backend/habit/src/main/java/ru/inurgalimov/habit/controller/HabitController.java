package ru.inurgalimov.habit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RestController;
import ru.inurgalimov.habit.api.HabitApi;
import ru.inurgalimov.habit.dto.Habit;
import ru.inurgalimov.habit.dto.HabitResponse;
import ru.inurgalimov.habit.service.HabitService;
import ru.inurgalimov.habit.util.HabitUtils;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class HabitController implements HabitApi {

    private final HabitService service;

    @Override
    @Cacheable(value = "habits", key = "#profile")
    public List<HabitResponse> getAll(String profile) {
        return service.getAllHabits(HabitUtils.getUserId(profile));
    }

    @Override
    @Cacheable(value = "habit", key = "#profile")
    public HabitResponse get(UUID habitId, String profile) {
        return service.getHabit(habitId, HabitUtils.getUserId(profile));
    }

    @Override
    @CacheEvict(value = {"habit", "habits"}, key = "#profile")
    public UUID create(Habit habit, String profile) {
        return service.createHabit(habit, HabitUtils.getUserId(profile));
    }

    @Override
    @CacheEvict(value = {"habit", "habits"}, key = "#profile")
    public void update(Habit habit, String profile) {
        service.update(habit, HabitUtils.getUserId(profile));
    }

    @Override
    @CacheEvict(value = {"habit", "habits"}, key = "#profile")
    public void delete(UUID habitId, String profile) {
        service.delete(habitId, HabitUtils.getUserId(profile));
    }

}
