package ru.inurgalimov.habit.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity(name = "progress")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProgressEntity extends BaseEntity {

    @Column(nullable = false)
    private Boolean status = false;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habit_id")
    private HabitEntity habit;

}
