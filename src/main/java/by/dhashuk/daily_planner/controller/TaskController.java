package by.dhashuk.daily_planner.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import by.dhashuk.daily_planner.dto.PageDTO;
import by.dhashuk.daily_planner.entity.DailyTask;
import by.dhashuk.daily_planner.service.DailyTaskService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/dailytask")
public class TaskController {

    public final DailyTaskService dailyService;

    public TaskController(DailyTaskService dailyService) {
        this.dailyService = dailyService;
    }

    @GetMapping("/hello/{name}")
    public String helloString(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // @GetMapping // all task
    // public ResponseEntity<PageDTO<DailyTask>> todoAllDailyList(@RequestParam Pageable pageable) {
    //     var tasks = dailyService.getAllDailyList();
    //     return ResponseEntity.ok(tasks);
    // }

    @GetMapping("/all")
    public List<DailyTask> getMethodName() {
        return dailyService.allTasks();
    }


    @GetMapping("/{id}") // get one task by Id
    public ResponseEntity<DailyTask> geDailyTaskbyId(@PathVariable Long id) {
        Optional<DailyTask> task = dailyService.getTaskById(id); // add DailyTaskDTO
        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/dailytask") // create daily task
    public ResponseEntity<DailyTask> postMethodName(@RequestBody DailyTask dailyTask) {
        Optional<DailyTask> createdTask = dailyService.createDailyTask(dailyTask);
        return createdTask.map(task -> ResponseEntity.status(HttpStatus.CREATED).body(task))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PutMapping("/dailytask/{id}") // update task all information - rewrite entity
    public ResponseEntity<DailyTask> updateDailyTask(@PathVariable String id, @RequestBody String entity) {
        return dailyService.updateDailyTask(id, entity);
    }

    @PatchMapping("/dailytask/{id}") // update task only some fields
    public ResponseEntity<DailyTask> updatePartOfDailyTask(@PathVariable String id,
            @RequestBody Map<String, Object> updates) {
        return dailyService.updateDailyTask(id, updates);
    }

    @DeleteMapping("/dailytask/{id}") // remove taks by id
    public ResponseEntity<Void> removeTask(@PathVariable String id) {
        if (!dailyService.removeDailyTask(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
