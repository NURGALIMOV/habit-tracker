package ru.inurgalimov.habit.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inurgalimov.habit.dto.Habit;
import ru.inurgalimov.habit.mapper.HabitMapper;
import ru.inurgalimov.habit.repository.HabitRepository;
import ru.inurgalimov.habit.service.HabitService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HabitServiceImpl implements HabitService {

    private final HabitRepository repository;
    private final HabitMapper mapper;

    @Override
    public List<Habit> getAllHabits(UUID userId) {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Habit getHabit(UUID uuid) {
        return mapper.toDto(repository.getById(uuid));
    }

    @Override
    public UUID createHabit(Habit habit) {
        return repository.save(mapper.toExtendedEntity(habit)).getId();
    }

    @Override
    public void update(Habit habit) {
        repository.save(mapper.toExtendedEntity(habit));
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

}
