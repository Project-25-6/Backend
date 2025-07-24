package backend.calendar.groups.service;

import backend.calendar.groups.domain.Groups;
import backend.calendar.groups.dto.request.GroupsRequest;
import backend.calendar.groups.dto.response.GroupsResponse;
import backend.calendar.groups.repository.GroupsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Group;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupsService {

    private final GroupsRepository groupRepository;

    @Transactional
    public GroupsResponse createGroup(GroupsRequest request, String userId) {

        String groupType = request.getGroupType();
        String inviteCode = null;

        if (groupType.equalsIgnoreCase("personal")) {
            inviteCode = generateInviteCode();
        }

        Groups group = Groups.builder()
                .name(request.getName())
                .groupType(groupType)
                .inviteCode(inviteCode)
                .userId(userId)
                .build();

        Groups savedGroup = groupRepository.save(group);

        return GroupsResponse.builder()
                .groupId(savedGroup.getId())
                .name(savedGroup.getName())
                .groupType(savedGroup.getGroupType())
                .inviteCode(savedGroup.getInviteCode())
                .build();
    }

    private String generateInviteCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
