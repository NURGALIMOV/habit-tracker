package ru.inurgalimov.habit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.inurgalimov.habit.api.HabitApi;
import ru.inurgalimov.habit.dto.Habit;
import ru.inurgalimov.habit.service.HabitService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class HabitController implements HabitApi {

    private final HabitService service;

    @Override
    public List<Habit> getAll() {
        //TODO id пользователя брать из контекста
        return service.getAllHabits(null);
    }

    @Override
    public Habit get(UUID habitId) {
        //TODO id пользователя брать из контекста
        return service.getHabit(habitId);
    }

    @Override
    public UUID create(Habit habit) {
        // TODO id пользователя брать из контекста
        return service.createHabit(habit);
    }

    @Override
    public void update(Habit habit) {
        // TODO id пользователя брать из контекста
        service.update(habit);
    }

    @Override
    public void delete(UUID habitId) {
        // TODO id пользователя брать из контекста
        service.delete(habitId);
    }

}
