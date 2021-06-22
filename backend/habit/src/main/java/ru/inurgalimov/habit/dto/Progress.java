package ru.inurgalimov.habit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ApiModel(description = "Прогресс привычки")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Progress {

    @ApiModelProperty(value = "Идентификатор прогресса")
    private UUID id;

    @NotNull
    @ApiModelProperty(value = "Статус", required = true)
    private Boolean status;

    @ApiModelProperty(value = "Дополнительное описание к отметке")
    private String description;

    @ApiModelProperty(value = "Идентификатор привычки")
    private UUID habitId;

    @ApiModelProperty(value = "Дата отметки")
    private LocalDate createDate;

}
