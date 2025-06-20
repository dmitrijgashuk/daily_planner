package by.dhashuk.daily_planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.dhashuk.daily_planner.entity.DailyTask;

public interface DailyTastRepository extends JpaRepository<DailyTask, Long> {

}
