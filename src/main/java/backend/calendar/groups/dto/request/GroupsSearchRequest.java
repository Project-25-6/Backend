package backend.calendar.groups.dto.request;

import lombok.Getter;

@Getter
public class GroupsSearchRequest {
    private String keyword; // 그룹 이름 검색 키워드
}
