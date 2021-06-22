package ru.inurgalimov.habit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.inurgalimov.habit.dto.Progress;
import ru.inurgalimov.habit.entity.HabitEntity;
import ru.inurgalimov.habit.entity.ProgressEntity;

@Mapper
public interface ProgressMapper {

    @Mapping(target = "habitId", ignore = true)
    Progress toDto(ProgressEntity entity);

    @Named("toEntity")
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "habit", ignore = true)
    ProgressEntity toEntity(Progress dto);

    @Named("toEntityWithDate")
    @Mapping(target = "habit", ignore = true)
    ProgressEntity toEntityWithDate(Progress dto);

    @Named("toEntityWithHabit")
    default ProgressEntity toEntityWithHabit(Progress dto) {
        ProgressEntity entity = toEntity(dto);
        var habit = new HabitEntity();
        habit.setId(dto.getHabitId());
        entity.setHabit(habit);
        return entity;
    }

}
