package backend.calendar.goal.controller;
import backend.calendar.goal.domain.enums.GoalDifficulty;
import backend.calendar.goal.dto.request.GoalRequest;
import backend.calendar.goal.service.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public ResponseEntity<Long> createGoal(@RequestBody GoalRequest requestDto) {
        Long successMessage = goalService.createGoal(requestDto);
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);

    }

}
