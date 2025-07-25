package backend.calendar.groups.controller;

import backend.calendar.groups.dto.request.GroupsRequest;
import backend.calendar.groups.dto.response.GroupsResponse;
import backend.calendar.groups.service.GroupsService;
import backend.calendar.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupsController {

    private final GroupsService groupsService;

    @PostMapping
    public ResponseEntity<String> createGroup(@RequestBody GroupsRequest request,
                                                     @AuthenticationPrincipal Member member) {

        groupsService.createGroup(request, member);
        return ResponseEntity.ok("그룹 생성 완료");
    }

    @GetMapping("/search")
    public ResponseEntity<List<GroupsResponse.GroupsSearchResponse>> searchGroups(@RequestParam String keyword) {
        return ResponseEntity.ok(groupsService.searchGroups(keyword));
    }
}