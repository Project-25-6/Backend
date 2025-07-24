package backend.calendar.goal.service;

import backend.calendar.goal.domain.Goal;
import backend.calendar.goal.dto.request.GoalRequest;
import backend.calendar.goal.repository.GoalRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;

    @Transactional
    public Long createGoal(GoalRequest goalRequest) {

        Goal goal = Goal.builder()
                .goalName(goalRequest.getGoalName())
                .goalType(goalRequest.getGoalType())
                .dueDate(goalRequest.getDueDate())
                .goalDifficulty(goalRequest.getGoalDifficulty())
                .build();

        Goal savedGoal = goalRepository.save(goal);
        return savedGoal.getId();
    }
}
