package backend.calendar.member.repository;

import backend.calendar.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository; // 엔티티 클래스를 사용하기 위해 임포트

import java.util.Optional; //조회 결과가 존재 할수도 있고 존재하지 않을 수도 있는 경우에 사용

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String email);
    Optional<Member> findByEmail(String email);
}
