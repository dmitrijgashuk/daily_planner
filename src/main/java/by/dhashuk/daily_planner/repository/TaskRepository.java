package by.dhashuk.daily_planner.repository;


import java.util.Optional;

import by.dhashuk.daily_planner.dto.PageDTO;

public interface TaskRepository<DailyTask> {

    PageDTO<DailyTask> getAllTask();

    Optional<DailyTask> getById(int id);

    Optional<DailyTask> saveDailyTask(DailyTask dailyTask);

}
