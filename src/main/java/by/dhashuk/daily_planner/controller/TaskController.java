package by.dhashuk.daily_planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import by.dhashuk.daily_planner.entity.DailyTask;
import by.dhashuk.daily_planner.service.DaskTaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class TaskController {
    @Autowired
    public DaskTaskService dailyService;

    @GetMapping("/dailytask")
    public List<DailyTask> todoAllDailyList() {
        //TODO add pagination
        return dailyService.getAllDailyList();
    }

    @GetMapping("/dailytask/{id}")
    public DailyTask geDailyTaskbyId(@PathVariable String id) {
        return dailyService.getTaskById(id);
    }

    @PostMapping("/dailytask")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        throw new UnsupportedOperationException("Create task Unsupported!");
    }

    @PutMapping("/dailytask/{id}")
    public String updateDailyTask(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        throw new UnsupportedOperationException("Update all task Unsupported!");
    }

    @PatchMapping("/dailytask/{id}")
    public DailyTask updatePartOfDailyTask(@PathVariable String id){
        //TODO: process Patch request
        throw new UnsupportedOperationException("Update part of task Unsupported!");
    }

    @DeleteMapping("/dailytask/{id}")
    public void removeTask(@PathVariable String id){
        //TODO: process Delete request
        throw new UnsupportedOperationException("Remove task Unsupported!");
    }
    
    
}
