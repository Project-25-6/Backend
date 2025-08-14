package backend.calendar.goal.service;

import backend.calendar.goal.domain.Goal;
import backend.calendar.goal.dto.request.GoalRequest;
import backend.calendar.goal.dto.response.MyGoalResponse;
import backend.calendar.goal.repository.GoalRepository;
import backend.calendar.member.domain.Member;
import backend.calendar.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long createGoal(GoalRequest goalRequest) {

        Member member = memberRepository.findById(goalRequest.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        Goal goal = Goal.builder()
                .goalName(goalRequest.getGoalName())
                .goalType(goalRequest.getGoalType())
                .dueDate(goalRequest.getDueDate())
                .goalDifficulty(goalRequest.getGoalDifficulty())
                .member(member)
                .build();

        Goal savedGoal = goalRepository.save(goal);
        return savedGoal.getId();
    }

    @Transactional
    public List<MyGoalResponse> findMyGoals(Long memberId){

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        List<Goal> myGoals = goalRepository.findAllByMember(member);

        return myGoals.stream()
                .map(MyGoalResponse::new) // GoalResponseDto의 생성자(Goal goal)를 사용
                .collect(Collectors.toList());
    }



}
