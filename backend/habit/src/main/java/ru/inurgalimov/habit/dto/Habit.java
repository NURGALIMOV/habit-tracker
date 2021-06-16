package ru.inurgalimov.habit.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode
@ApiModel(description = "Привычка")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Habit {

    @ApiModelProperty(value = "Идентификатор привычки")
    private UUID id;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "Наименование привычки", required = true)
    private String name;

    @NotNull
    @ApiModelProperty(value = "Признак для уведомлений", required = true)
    private Boolean isNotify;

    @ApiModelProperty(value = "Уведомление")
    private List<Notification> notifies;

    @ApiModelProperty(value = "Описание")
    private String description;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private UUID userId;

}
