package ru.inurgalimov.habit.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity(name = "habit")
@Data
@EqualsAndHashCode(callSuper = true)
public class HabitEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean isNotify = false;

    @OneToMany(mappedBy = "habit", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<NotificationEntity> notifies;

    private String description;

    @Column(nullable = false)
    private Boolean isActive = true;

    @OneToMany(mappedBy = "habit", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<ProgressEntity> progress;

}
