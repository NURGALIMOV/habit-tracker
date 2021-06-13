package ru.inurgalimov.habit.service;

import ru.inurgalimov.habit.dto.Progress;

import java.util.UUID;

public interface ProgressService {

    UUID createProgress(Progress progress);

}
