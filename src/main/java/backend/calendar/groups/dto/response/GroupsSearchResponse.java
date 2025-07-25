package backend.calendar.groups.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GroupsSearchResponse {
    private Long groupId;
    private String name;
    private String groupType; // "public" or "personal"
}