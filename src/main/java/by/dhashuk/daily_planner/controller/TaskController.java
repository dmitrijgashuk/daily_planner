package by.dhashuk.daily_planner.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import by.dhashuk.daily_planner.entity.DailyTask;
import by.dhashuk.daily_planner.repository.DailyTastRepository;

@RestController
@RequestMapping("/api/v1/daily_task")
public class TaskController {
    private final DailyTastRepository repository;

    public TaskController(DailyTastRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public String getAllTasks(){
        return "Get all Tasks";
    }

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable Long id){
        return "Get current Task by id=" + id + "!";
    }

    @PostMapping()
    public String addNewTask(@RequestBody DailyTask dailyTask){
        return "Create new " + dailyTask.getName() + " Task!";
    }

    @DeleteMapping("/{id}")
    public String removeTaskById(@PathVariable Long id){
        return "Remove Task by id="+ id +"!";
    }

    @PutMapping("/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody DailyTask task){
        return "Update all field of id=" + id + " task  name=" + task.getName() +" task!";
    }

    @PatchMapping("/{id}")
    public String updateCurrentTaskFields(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return "Update some fields=" + fields + " of id=" + id + " task!";
    }

}
