package by.dhashuk.daily_planner.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import by.dhashuk.daily_planner.entity.DailyTask;

@RestController
public class TaskController {
    @GetMapping("/todolist")
    public List<DailyTask> todoDailyList() {
        return null;
    }
    
}
