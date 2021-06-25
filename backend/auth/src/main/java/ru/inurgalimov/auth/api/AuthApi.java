package ru.inurgalimov.auth.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inurgalimov.auth.dto.User;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(tags = "auth", value = "Auth api")
@RequestMapping("/api/v1/auth")
public interface AuthApi {

    @ApiOperation(value = "Получение пользователей системы", nickname = "users", responseContainer = "List")
    @GetMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
    List<User> getAll();

    @ApiOperation(value = "Регистрация в системе", nickname = "registration", response = UUID.class)
    @PostMapping(value = "/users", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<UUID> register(@RequestBody @Valid @NotNull @NotBlank User user);

    @ApiOperation(value = "Обновление данных пользователя", nickname = "update", response = UUID.class)
    @PutMapping(value = "/users", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    User update(@RequestBody @Valid @NotNull @NotBlank User user);

    @ApiOperation(value = "Обновление пароля", nickname = "change-password", response = String.class)
    @PatchMapping(value = "/users/{userId}/password")
    String changePassword(@PathVariable("userId") @Valid @NotNull @NotBlank UUID userId,
                          @Valid @NotNull @NotBlank @RequestBody String password);

    @ApiOperation(value = "Проверка токена", nickname = "validate-token")
    @GetMapping
    ResponseEntity validateToken(@RequestHeader("Authorization") String token);

    @ApiOperation(value = "Вход в систему", nickname = "validate-token", response = String.class)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<User> login(@RequestBody @Valid @NotNull @NotBlank User user);

}
