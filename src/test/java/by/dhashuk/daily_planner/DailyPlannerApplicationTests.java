package by.dhashuk.daily_planner;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import by.dhashuk.daily_planner.entity.DailyTask;
import by.dhashuk.daily_planner.service.DailyTaskService;

@SpringBootTest
class DailyPlannerApplicationTests {
	@Autowired
	private DailyTaskService dailyTaskService;

	private DailyTask tempDailyTask;

	@BeforeEach
	public void setUp(){
		tempDailyTask = new DailyTask();
		tempDailyTask.setName("Temporary task");
		tempDailyTask.setDescription("Simple temporary task for my bse test");
		tempDailyTask.setEstimatedDuration(Duration.ofMinutes(20));
		tempDailyTask.setPlannedTime(LocalTime.of(18, 25));
		tempDailyTask.setCompleted(false);
		dailyTaskService.saveDailyTask(tempDailyTask);
	}

	@Test
	public void throwExeptionWhenDailyTaskIdNull() {
		Assertions.assertTrue(true);
	}

	@Test
	public void fatchExistinDailyTaskById(){
		Optional<DailyTask> dailyTaskById = dailyTaskService.findDailyTaskById(tempDailyTask.getId());
		Assertions.assertTrue(dailyTaskById.isPresent());
	}

	@AfterEach
	public void tearDown(){
		dailyTaskService.removeDailyTask(tempDailyTask);
	}	

}
