package by.dhashuk.daily_planner.entity;

import java.time.Duration;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class DailyTask   {
    //private String id = UUID.randomUUID().toString();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @JsonProperty("duration")
    @Column(name = "duration")
    private Duration estimatedDuration;
    @Column(name = "planned_time")
    private LocalTime plannedTime;
    @Column(name = "is_complited")
    private boolean isCompleted;
    
}
