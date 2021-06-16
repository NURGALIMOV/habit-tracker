package ru.inurgalimov.habit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.inurgalimov.habit.dto.enums.NotificationType;

import javax.persistence.Column;
import java.time.LocalTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
@ApiModel(description = "Уведомление")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Notification {

    @ApiModelProperty(value = "Идентификатор уведомления")
    private UUID id;

    @ApiModelProperty(value = "Тип уведомления")
    private NotificationType notificationType;

    @ApiModelProperty(value = "Время увеломления")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime notificationTime = LocalTime.of(18, 0);

    @ApiModelProperty(value = "Идентификатор привычки")
    private UUID habitId;

    @ApiModelProperty(value = "Электронная почта для уведомлений")
    private String email;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private UUID userId;

}
