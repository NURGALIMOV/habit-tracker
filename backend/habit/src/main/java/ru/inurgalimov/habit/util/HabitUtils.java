package ru.inurgalimov.habit.util;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class HabitUtils {

    public UUID getUserId(String profile) {
        return UUID.fromString(profile.split("_")[0]);
    }

}
