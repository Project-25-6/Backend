package backend.calendar.groups.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`groups`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String groupType; // "personal" or "public"

    private String inviteCode;

    private String userId; // 생성자 ID
}
