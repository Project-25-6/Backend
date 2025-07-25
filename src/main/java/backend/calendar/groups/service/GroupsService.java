package backend.calendar.groups.service;

import backend.calendar.groups.domain.Groups;
import backend.calendar.groups.dto.request.GroupsRequest;
import backend.calendar.groups.dto.response.GroupsResponse;
import backend.calendar.groups.dto.response.GroupsSearchResponse;
import backend.calendar.groups.repository.GroupsRepository;
import backend.calendar.member.domain.Member;
import backend.calendar.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Group;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupsService {

    private final GroupsRepository groupRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createGroup(GroupsRequest request, Member member) {

        String groupType = request.getGroupType();
        String inviteCode = null;

        if (groupType.equalsIgnoreCase("personal")) {
            inviteCode = generateInviteCode();
        }

        Groups group = Groups.builder()
                .name(request.getName())
                .groupType(groupType)
                .inviteCode(inviteCode)
                .member(member)
                .build();

        groupRepository.save(group);

    }

    public List<GroupsSearchResponse> searchGroups(String keyword) {
        return groupRepository.findByNameContaining(keyword).stream()
                .map(group -> new GroupsSearchResponse(
                        group.getId(),
                        group.getName(),
                        group.getGroupType()))
                .collect(Collectors.toList());
    }

    private String generateInviteCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
