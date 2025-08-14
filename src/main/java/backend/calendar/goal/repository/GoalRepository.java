package backend.calendar.goal.repository;

import backend.calendar.goal.domain.Goal;
import backend.calendar.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {


    List<Goal> findAllByMember(Member member);
}
