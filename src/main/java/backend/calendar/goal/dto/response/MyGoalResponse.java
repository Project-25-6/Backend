package backend.calendar.goal.dto.response;

import backend.calendar.goal.domain.Goal;
import backend.calendar.goal.domain.enums.GoalDifficulty;
import backend.calendar.goal.domain.enums.GoalType;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class MyGoalResponse {

    private Long goalId;
    private String goalName;
    private GoalType goalType;
    private GoalDifficulty difficulty;
    private LocalDate createdAt;
    private Boolean achievement;

    // Goal 엔티티를 DTO로 변환하는 생성자
    public MyGoalResponse(Goal goal) {
        this.goalId = goal.getId();
        this.goalName = goal.getGoalName();
        this.achievement = goal.isAchievement();
        this.goalType = goal.getGoalType();
        this.difficulty = goal.getGoalDifficulty();
        this.createdAt = goal.getDueDate();
    }



}
