package by.dhashuk.daily_planner.repository;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import by.dhashuk.daily_planner.dto.PageDTO;
import by.dhashuk.daily_planner.entity.DailyTask;

@Repository
public class DailyTaskRepository implements TaskRepository<DailyTask> {
    private List<DailyTask> dailyList = List.of(
    //     new DailyTask("1", "Wake up", "null", Duration.ofMillis(1), LocalTime.of(7, 15), false),            new DailyTask("2", "Make breakfast", "null", Duration.ofMinutes(20), LocalTime.of(7, 30), false),
    //     new DailyTask("3", "exercise", "null", Duration.ofMillis(45), LocalTime.of(8, 0), false)
    );

    @Override
    public PageDTO<DailyTask> getAllTask() {
        return null;
    }

    @Override
    public Optional<DailyTask> getById(int id) {
        return dailyList.stream()
        .filter(task -> Objects.equals(task.getId(), Integer.toString(id)))
        .findFirst();
    }

    @Override
    public Optional<DailyTask> saveDailyTask(DailyTask dailyTask) {
        dailyList.add(dailyTask);
        return dailyList.stream()
        .filter(task -> Objects.equals(task, dailyTask)).findFirst();
    }

    
}
