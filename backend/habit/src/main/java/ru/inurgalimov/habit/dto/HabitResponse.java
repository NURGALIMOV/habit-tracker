package ru.inurgalimov.habit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "Привычка (ответ)")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HabitResponse extends Habit {

    @ApiModelProperty("Статус привычки")
    private Boolean isActive;

    @ApiModelProperty("Прогресс")
    private List<Progress> progress;

    @ApiModelProperty("Дата создания")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate createDate;

}
