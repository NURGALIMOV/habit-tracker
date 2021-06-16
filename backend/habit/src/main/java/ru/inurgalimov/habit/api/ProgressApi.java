package ru.inurgalimov.habit.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.inurgalimov.habit.dto.Progress;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(tags = "progress", value = "Api прогресса")
@RequestMapping("/api/v1/progress")
public interface ProgressApi {

    @ApiOperation(value = "Создание отметки о прогрессе", nickname = "create progress", response = UUID.class)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    UUID createProgress(@RequestBody @Valid @NotNull Progress progress);

}
