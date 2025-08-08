package backend.calendar.member.controller;

import backend.calendar.member.dto.request.LoginRequest;
import backend.calendar.member.dto.response.LoginResponse;
import backend.calendar.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final MemberService memberService;


    @Operation(summary = "로그인", description = "이메일과 패스워드로 로그인합니다.")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = memberService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "로그아웃", description = "현재 사용자를 로그아웃 처리합니다.")
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String authHeader) {
        // "Bearer " 접두사 제거
        String token = authHeader.replace("Bearer ", "");
        memberService.logout(token);
        return ResponseEntity.ok().build();
    }
}

