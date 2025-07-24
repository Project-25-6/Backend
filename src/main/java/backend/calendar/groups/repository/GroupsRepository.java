package backend.calendar.groups.repository;

import backend.calendar.groups.domain.Groups;
import org.apache.catalina.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupsRepository extends JpaRepository<Groups, Long> {

    boolean existsByName(String name);

    Optional<Groups> findByInviteCode(String inviteCode);
}