package by.dhashuk.daily_planner;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("If id equals null ")
	public void throwExeptionWhenIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class,
						() -> dailyTaskService.findDailyTaskById(null));
	}

	@Test
	@DisplayName("Check find existing daily task by id")
	public void fatchExistinDailyTaskById(){
		Long tastId = tempDailyTask.getId();
		Optional<DailyTask> dailyTaskById  = dailyTaskService.findDailyTaskById(tastId);
		
		Assertions.assertTrue(dailyTaskById.isPresent());
	}

	@Test
	@DisplayName("Test update DailyTask fields by Map key-value data")
	public void updateDailyTaskField(){
		String newDescriptionField = "This is my new description for my tempori task";
		Optional<DailyTask> saveDailyTask = dailyTaskService.saveDailyTask(tempDailyTask);
		Optional<DailyTask> updateDailyTaskByFields = 
				dailyTaskService.updateDailyTaskByFields(saveDailyTask.get().getId(), 
										Map.of("description", newDescriptionField));
										
		Assertions.assertEquals(updateDailyTaskByFields.get().getDescription(), newDescriptionField);
	}

	@AfterEach
	public void tearDown(){
		dailyTaskService.removeDailyTask(tempDailyTask);
	}	

}
