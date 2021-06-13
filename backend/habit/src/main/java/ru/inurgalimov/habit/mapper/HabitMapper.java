package ru.inurgalimov.habit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.inurgalimov.habit.dto.Habit;
import ru.inurgalimov.habit.dto.HabitResponse;
import ru.inurgalimov.habit.entity.HabitEntity;

@Mapper(uses = {
        NotificationMapper.class,
        ProgressMapper.class
})
public interface HabitMapper {

    HabitResponse toDto(HabitEntity entity);

    @Named("toEntity")
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "progress", ignore = true)
    HabitEntity toEntity(Habit habit);

    @Named("toExtendedEntity")
    default HabitEntity toExtendedEntity(Habit habit) {
        HabitEntity entity = toEntity(habit);
        entity.getNotifies().forEach(notify -> notify.setHabit(entity));
        return entity;
    }

}
