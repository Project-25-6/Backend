package backend.calendar.groups.controller;

import backend.calendar.groups.dto.request.GroupsRequest;
import backend.calendar.groups.dto.response.GroupsResponse;
import backend.calendar.groups.service.GroupsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupsController {

    private final GroupsService groupsService;

    @PostMapping
    public ResponseEntity<GroupsResponse> createGroup(@RequestBody GroupsRequest request,
                                         @AuthenticationPrincipal String userId) {

        GroupsResponse response = groupsService.createGroup(request, userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
