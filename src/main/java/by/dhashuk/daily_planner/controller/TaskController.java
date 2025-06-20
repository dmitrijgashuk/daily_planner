package by.dhashuk.daily_planner.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import by.dhashuk.daily_planner.entity.DailyTask;
import by.dhashuk.daily_planner.repository.DailyTastRepository;

@RestController
public class TaskController {
    private final DailyTastRepository repository;

    public TaskController(DailyTastRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<DailyTask> todoDailyList() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public DailyTask getDailyTaskById (@PathVariable Long id){
        return repository.findById(id).get();
    }

}
