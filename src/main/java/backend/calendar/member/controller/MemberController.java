package backend.calendar.member.controller;

import backend.calendar.member.dto.request.MemberRequest;
import backend.calendar.member.repository.MemberRepository;
import backend.calendar.member.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping ("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody MemberRequest requestDto) {
        String successMessage = memberService.signUp(requestDto);
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

}
