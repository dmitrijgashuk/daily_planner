package by.dhashuk.daily_planner.entity;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.boot.context.properties.bind.Name;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DailyTask   {
    private String id;
    private String name;
    private String description;
    @JsonProperty("duration")
    private Duration estimatedDuration;
    private LocalTime plannedTime;
    private boolean isCompleted;
}
