package ru.inurgalimov.habit.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inurgalimov.habit.dto.Habit;
import ru.inurgalimov.habit.dto.HabitResponse;
import ru.inurgalimov.habit.exception.HabitException;
import ru.inurgalimov.habit.exception.NotFoundException;
import ru.inurgalimov.habit.mapper.HabitMapper;
import ru.inurgalimov.habit.repository.HabitRepository;
import ru.inurgalimov.habit.service.HabitService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HabitServiceImpl implements HabitService {

    private final HabitRepository repository;
    private final HabitMapper mapper;

    @Override
    public List<HabitResponse> getAllHabits(UUID userId) {
        return repository.findAllByUserId(userId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<HabitResponse> getAllHabits() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public HabitResponse getHabit(UUID uuid, UUID userId) {
        return repository.findByIdAndUserId(uuid, userId)
                .map(mapper::toDto)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public UUID createHabit(Habit habit, UUID userId) {
        habit.setUserId(userId);
        return repository.save(mapper.toExtendedEntity(habit)).getId();
    }

    @Override
    public void update(Habit habit, UUID userId) throws NotFoundException {
        if (Objects.isNull(habit) || Objects.isNull(habit.getId())) {
            throw new HabitException();
        }
        if (repository.findByIdAndUserId(habit.getId(), userId).isPresent()) {
            repository.save(mapper.toExtendedEntity(habit));
            return;
        }
        throw new NotFoundException("Not found habit for current user");
    }

    @Override
    public void delete(UUID uuid, UUID userId) {
        if (repository.findByIdAndUserId(uuid, userId).isPresent()) {
            repository.deleteById(uuid);
            return;
        }
        throw new NotFoundException("Not found habit for current user");
    }

}
