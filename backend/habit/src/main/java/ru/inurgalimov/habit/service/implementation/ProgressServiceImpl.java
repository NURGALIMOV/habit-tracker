package ru.inurgalimov.habit.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inurgalimov.habit.dto.Progress;
import ru.inurgalimov.habit.mapper.ProgressMapper;
import ru.inurgalimov.habit.repository.ProgressRepository;
import ru.inurgalimov.habit.service.ProgressService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository repository;
    private final ProgressMapper mapper;

    public UUID createProgress(Progress progress) {
        return repository.save(mapper.toEntityWithHabit(progress)).getId();
    }

}
