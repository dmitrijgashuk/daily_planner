package by.dhashuk.daily_planner.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.dhashuk.daily_planner.entity.DailyTask;
import by.dhashuk.daily_planner.repository.DailyTastRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DailyTaskService {
    private final DailyTastRepository repository;

    public DailyTaskService(DailyTastRepository repository) {
        this.repository = repository;
    }

    public Optional<DailyTask> findDailyTaskById(Long id) {
        if (id == null) {
        throw new IllegalArgumentException("Id must not be null");
        }
        return repository.findById(id);
    }

    @Transactional
    public Optional<DailyTask> saveDailyTask(DailyTask dailyTask) {
        try {
            DailyTask task = repository.save(dailyTask);
            return Optional.of(task);
        } catch (DataIntegrityViolationException e) {
            return Optional.empty();
        }
    }

    public List<DailyTask> findAllDailyTasks() {
        return repository.findAll();
    }

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

    public boolean removeDailyTask(DailyTask dailyTask) {
        try {
            repository.delete(dailyTask);
            return true;
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
    }

    @Transactional
    public Optional<DailyTask> updateDailyTask(Long id, DailyTask dailyTask) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        dailyTask.setId(id);
        return Optional.of(repository.save(dailyTask));
    }

    @Transactional
    public Optional<DailyTask> updateDailyTaskByFields(Long id, Map<String, Object> fields) {
       try {
            DailyTask entity = repository.findById(id)
                .orElseThrow();

        fields.forEach((feildName, value) -> {
            Field requiredField = ReflectionUtils.getRequiredField(DailyTask.class, feildName);
            if (requiredField != null) {
                requiredField.setAccessible(true);
                ReflectionUtils.setField(requiredField, entity, value);
                }   
            });
            return Optional.of(repository.save(entity));

       } catch (IllegalArgumentException | NoSuchElementException e) {
            return Optional.empty();
       }           
    }
}
