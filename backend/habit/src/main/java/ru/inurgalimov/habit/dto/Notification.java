package ru.inurgalimov.habit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.inurgalimov.habit.dto.enums.NotificationType;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Уведомление")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Notification implements Serializable {

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
