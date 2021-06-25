package ru.inurgalimov.auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "Пользователь")
@Data
@EqualsAndHashCode
public class User {

    @ApiModelProperty(value = "Идентификатор")
    private UUID id;

    @ApiModelProperty(value = "Имя")
    private String firstName;

    @ApiModelProperty(value = "Фамилия")
    private String lastName;

    @ApiModelProperty(value = "Отчество")
    private String middleName;

    @NotNull
    @NotBlank
    @Email
    @ApiModelProperty(value = "Логин", required = true)
    private String login;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "Пароль", required = true)
    private String password;

    @JsonIgnore
    private Role role;

    private String token;

}
