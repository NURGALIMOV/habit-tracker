package ru.inurgalimov.habit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.inurgalimov.habit.dto.Notification;
import ru.inurgalimov.habit.entity.HabitEntity;
import ru.inurgalimov.habit.entity.NotificationEntity;

@Mapper
public interface NotificationMapper {

    @Mapping(target = "habitId", ignore = true)
    Notification toDto(NotificationEntity entity);

    @Named("toEntity")
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "habit", ignore = true)
    NotificationEntity toEntity(Notification dto);

    @Named("toEntityWithHabit")
    default NotificationEntity toEntityWithHabit(Notification dto) {
        NotificationEntity entity = toEntity(dto);
        var habit = new HabitEntity();
        habit.setId(dto.getHabitId());
        entity.setHabit(habit);
        return entity;
    }



}
