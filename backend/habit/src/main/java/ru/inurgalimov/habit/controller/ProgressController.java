package ru.inurgalimov.habit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.inurgalimov.habit.api.ProgressApi;
import ru.inurgalimov.habit.dto.Progress;
import ru.inurgalimov.habit.service.ProgressService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProgressController implements ProgressApi {

    private final ProgressService service;

    @Override
    public UUID createProgress(Progress progress) {
        return service.createProgress(progress);
    }

}
