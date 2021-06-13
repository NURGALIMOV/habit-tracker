package ru.inurgalimov.habit.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.inurgalimov.habit.dto.Notification;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(tags = "notify", value = "Api для добавления увеломлений")
@RequestMapping("/api/v1/notifications")
public interface NotificationApi {

    @ApiOperation(value = "Создание уведомления", nickname = "create-notifications", response = UUID.class)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    UUID create(@RequestBody @Valid @NotNull Notification notification);

    @ApiOperation(value = "Обновление уведомления", nickname = "update-notifications")
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    Notification update(@RequestBody @Valid @NotNull Notification notification);

    @ApiOperation(value = "Удаление уведомления", nickname = "delete-notifications")
    @DeleteMapping("/{notificationId}")
    void delete(@PathVariable @Valid @NotNull UUID notificationId);

}
