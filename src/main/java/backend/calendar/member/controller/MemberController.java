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
        try {
            // Service 계층의 회원가입 로직 호출
            String message = memberService.signUp(requestDto);
            // 성공 시 201 Created 상태 코드와 메시지 반환
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Service에서 발생시킨 비즈니스 예외 (예: 중복 아이디/이메일) 처리
            // 400 Bad Request 상태 코드와 예외 메시지 반환
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // 그 외 예상치 못한 모든 예외 처리
            // 500 Internal Server Error 상태 코드와 일반적인 오류 메시지 반환
            return new ResponseEntity<>("회원가입 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
