package by.dhashuk.daily_planner.dto;

public record DailyTaskDto(String id, String name, long estimatedDurationMinutes, String plannedTime, boolean isCompleted) {

}
