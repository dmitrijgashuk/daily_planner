package by.dhashuk.daily_planner.entity;

import java.time.LocalTime;

import ch.qos.logback.core.util.Duration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DailyTask {
    private String id;
    private String name;
    private String description;
    private Duration estimatedDuration;
    private LocalTime plannedTime;
    private boolean isCompleted;
}
