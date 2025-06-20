package by.dhashuk.daily_planner.entity;

import java.time.Duration;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily_task")
public class DailyTask   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "estimeted_duration")
    private Duration estimatedDuration;
    @Column(name = "planned_time")
    private LocalTime plannedTime;
    @Column (name = "is_complited")
    private boolean isCompleted;

    public DailyTask() {
    }

    public DailyTask(Long id, String name, String description, Duration estimatedDuration, LocalTime plannedTime,
            boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.estimatedDuration = estimatedDuration;
        this.plannedTime = plannedTime;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Duration getEstimatedDuration() {
        return estimatedDuration;
    }
    public void setEstimatedDuration(Duration estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }
    public LocalTime getPlannedTime() {
        return plannedTime;
    }
    public void setPlannedTime(LocalTime plannedTime) {
        this.plannedTime = plannedTime;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

}
