package by.dhashuk.daily_planner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import by.dhashuk.daily_planner.dto.PageDTO;
import by.dhashuk.daily_planner.entity.DailyTask;
import by.dhashuk.daily_planner.repository.DailyDataRepository;

@Service
public class DailyTaskService {
    
    private final DailyDataRepository dailyTaskRepository;

    public DailyTaskService(DailyDataRepository dailyTaskRepository) {
        this.dailyTaskRepository = dailyTaskRepository;
    }

    public PageDTO<DailyTask> getAllDailyList() {
        throw new UnsupportedOperationException();
    }

    public Optional<DailyTask> getTaskById(Long id){
        return dailyTaskRepository.findById(id);
    }

    public Optional<DailyTask> createDailyTask(DailyTask dailyTask) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createDailyTask'");
    }

    public ResponseEntity<DailyTask> updateDailyTask(String id, String entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDailyTask'");
    }

    public ResponseEntity<DailyTask> updateDailyTask(String id, Map<String, Object> updates) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDailyTask'");
    }

    public boolean removeDailyTask(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeDailyTask'");
    }

    public List<DailyTask> allTasks() {
       ArrayList<DailyTask> dailyTasks = new ArrayList<>();
       for(DailyTask task: dailyTaskRepository.findAll() ){
            dailyTasks.add(task);
       } 
       return dailyTasks;
    }

}
