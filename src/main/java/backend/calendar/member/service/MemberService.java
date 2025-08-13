package backend.calendar.member.service;

import backend.calendar.member.domain.Member;
import backend.calendar.member.dto.request.MemberRequest;
import backend.calendar.member.dto.response.LoginResponse;
import backend.calendar.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@RequiredArgsConstructor //final 필드 생성자 자동 생성
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;



    @Transactional
    public String signUp(MemberRequest requestDto) {


        String email = requestDto.getEmail();

        Integer age = requestDto.getAge();
        String gender = requestDto.getGender();
        String job = requestDto.getJob();
        String address = requestDto.getAddress();
        Integer point = requestDto.getPoint(); // DTO에서 모든 필드를 가져옵니다.
        String profileUrlImage = requestDto.getProfileImageUrl();

        // 아이디 중복 확인
        if (memberRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        Member newMember = new Member(email, encodedPassword,profileUrlImage, age, gender, job, address,point); // 암호화된 비밀번호 사용
        memberRepository.save(newMember);

        return "회원가입이 성공적으로 완료되었습니다.";
    }

    public LoginResponse login(String email, String password) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("이메일을 찾을 수 없습니다."));

        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtTokenProvider.createToken(member.getId(), member.getEmail());
        return new LoginResponse(token);
    }

    public void logout(String token) {
        if (!jwtTokenProvider.validateToken(token)) {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.");
        }

    }
}
