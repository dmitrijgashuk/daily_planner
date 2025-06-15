package by.dhashuk.daily_planner.service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import by.dhashuk.daily_planner.entity.DailyTask;

@Service
public class DaskTaskService {
    private List<DailyTask> dailyList = List.of(
            new DailyTask("1", "Wake up", "null", Duration.ofMillis(1), LocalTime.of(7, 15), false),
            new DailyTask("2", "Make breakfast", "null", Duration.ofMinutes(20), LocalTime.of(7, 30), false),
            new DailyTask("3", "exercise", "null", Duration.ofMillis(45), LocalTime.of(8, 0), false));

    public List<DailyTask> getAllDailyList() {
        return dailyList;
    }

    public DailyTask getTaskById(String id) {
        Integer taskId = Integer.parseInt(id) - 1;
        return dailyList.get(taskId);
    }

}
