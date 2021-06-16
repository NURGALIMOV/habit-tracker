package ru.inurgalimov.habit.util;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@UtilityClass
public class HabitUtils {

    @Value("${habit.property.delimiter}")
    private String delimiter;

    @NotNull
    public UUID getUserId(String profile) {
        return UUID.fromString(profile.split(delimiter)[0]);
    }

}
