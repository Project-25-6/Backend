package backend.calendar.groups.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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