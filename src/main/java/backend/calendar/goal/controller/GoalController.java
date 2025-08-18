package backend.calendar.goal.controller;
import backend.calendar.goal.domain.enums.GoalDifficulty;
import backend.calendar.goal.dto.request.GoalRequest;
import backend.calendar.goal.dto.response.GoalResponse;
import backend.calendar.goal.dto.response.MyGoalResponse;
import backend.calendar.goal.service.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping
    public ResponseEntity<List<MyGoalResponse>> getMyGoals(@RequestParam Long memberId){

        List<MyGoalResponse> response = goalService.findMyGoals(memberId);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{goalId}")
    public ResponseEntity<String> deleteGoal(@PathVariable Long goalId, @RequestParam Long memberId) {
        goalService.deleteGoal(goalId,memberId);
        return ResponseEntity.ok("목표가 삭제되었습니다.");

    }



}
