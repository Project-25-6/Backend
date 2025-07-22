package backend.calendar.member.service;

import backend.calendar.member.domain.Member;
import backend.calendar.member.dto.request.MemberRequest;
import backend.calendar.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;


@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public String signUp(MemberRequest requestDto) {


        String email = requestDto.getEmail();
        String password = requestDto.getPassword();
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

        String encodedPassword = password;

        // Member 엔티티의 생성자를 사용
        Member newMember = new Member(email, encodedPassword, profileUrlImage, age, gender, job, address,point);

        memberRepository.save(newMember);

        return "회원가입이 성공적으로 완료되었습니다.";
    }
}
