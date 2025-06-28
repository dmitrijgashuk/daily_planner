package by.dhashuk.daily_planner.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import by.dhashuk.daily_planner.entity.DailyTask;
import by.dhashuk.daily_planner.repository.DailyTastRepository;

public class DailyTaskService {
    private final DailyTastRepository repository;

    public DailyTaskService(DailyTastRepository repository) {
        this.repository = repository;
    }

    // find task by id - if id is null throw exception or if task does not found
    // return empty
    public Optional<DailyTask> findDailyTaskById(Long id) {
        return repository.findById(id);
    }

    // return saved task if task isExists return empty Optional
    public Optional<DailyTask> saveDailyTask(DailyTask dailyTask) {
        try {
            DailyTask task = repository.save(dailyTask);
            return Optional.of(task);
        } catch (DataIntegrityViolationException e) {
            // логування або кастомна обробка
            return Optional.empty();
        }
    }

    // return all taks or empty list
    public List<DailyTask> findAllDailyTasks() {
        return repository.findAll();
    }

    // remove task by id
    @Transactional
    public boolean removeDailyTaskById(Long id) {
        if (id == null) {
            return false;
        }
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Transactional
    public Optional<DailyTask> updateDailyTask(Long id, DailyTask dailyTask) {
        return null;
    }


    @Transactional
    public Optional<DailyTask> updateDailyTaskByFields(Long id, Map<String, Object> fields) {
        return null;
    }
}
