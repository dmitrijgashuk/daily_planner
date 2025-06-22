package by.dhashuk.daily_planner.service;

import java.util.List;
import java.util.Optional;

import by.dhashuk.daily_planner.entity.DailyTask;
import by.dhashuk.daily_planner.repository.DailyTastRepository;

public class DailyTaskService {
    private final DailyTastRepository repository;

    public DailyTaskService(DailyTastRepository repository) {
        this.repository = repository;
    }
    
    // find task by id - if id is null throw exception or if task does not found return empty
    public Optional<DailyTask>  getDailyTaskById(Long id){
        return repository.findById(id);
    }

    // return saved task if task isExists return empty Optional
    public Optional<DailyTask> createTask(DailyTask dailyTask){
        boolean isExists = repository.existsById(dailyTask.getId());
        if(isExists){
            return Optional.empty();
        }
        
        DailyTask task = repository.save(dailyTask);
        return Optional.of(task);
    }

    // return all taks or empty list
    public List<DailyTask> findAllDailyTasks(){
        return null;
    }
}
