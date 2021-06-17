package ru.inurgalimov.notification.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode
public class Message {

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String heading;

    @NotNull
    @NotBlank
    private String text;

}
