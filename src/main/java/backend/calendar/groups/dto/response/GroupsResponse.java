package backend.calendar.groups.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupsResponse {

    private Long groupId;
    private String name;
    private String groupType;
    private String inviteCode;

}
