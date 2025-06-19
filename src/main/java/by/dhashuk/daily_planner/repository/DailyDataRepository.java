package by.dhashuk.daily_planner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.dhashuk.daily_planner.entity.DailyTask;

@Repository
public interface DailyDataRepository extends CrudRepository<DailyTask,Long> {

}
