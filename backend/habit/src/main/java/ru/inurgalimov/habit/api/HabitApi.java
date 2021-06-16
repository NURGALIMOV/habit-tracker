package ru.inurgalimov.habit.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.inurgalimov.habit.dto.Habit;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(tags = "habit", value = "Api привычек")
@RequestMapping("/api/v1/habits")
public interface HabitApi {

    @ApiOperation(value = "Получение привычек пользователя", nickname = "habits", responseContainer = "List")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<Habit> getAll(@RequestHeader("X-Profile") @Valid @NotNull @NotBlank String profile);

    @ApiOperation(value = "Получение привычки пользователя", nickname = "habit", response = Habit.class)
    @GetMapping(value = "/{habitId}", produces = APPLICATION_JSON_VALUE)
    Habit get(
            @PathVariable @Valid @NotNull UUID habitId,
            @RequestHeader("X-Profile") @Valid @NotNull @NotBlank String profile);

    @ApiOperation(value = "Создание привычки", nickname = "create", response = UUID.class)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    UUID create(
            @RequestBody @Valid @NotNull Habit habit,
            @RequestHeader("X-Profile") @Valid @NotNull @NotBlank String profile);

    @ApiOperation(value = "Обновление привычки", nickname = "update")
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    void update(
            @RequestBody @Valid @NotNull Habit habit,
            @RequestHeader("X-Profile") @Valid @NotNull @NotBlank String profile);

    @ApiOperation(value = "Удаление привычки", nickname = "delete")
    @DeleteMapping("/{habitId}")
    void delete(
            @PathVariable @Valid @NotNull UUID habitId,
            @RequestHeader("X-Profile") @Valid @NotNull @NotBlank String profile);

}
