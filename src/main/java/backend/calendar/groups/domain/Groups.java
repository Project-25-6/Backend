package backend.calendar.groups.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "`Group`")  // 예약어 우려 시 @Table(name = "`Group`") 가능
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Group_ID")
    private Long id;

    @Column(name = "User_ID")
    private String userId;

    @Column(name = "Group_Name")
    private String name;

    @Column(name = "Group_deadline")
    private LocalDate deadline;

    @Column(name = "Group_Board")
    private String board;

    @Column(name = "Group_Type")
    private String groupType;

    @Column(name = "Invite_Code")
    private String inviteCode;
}
