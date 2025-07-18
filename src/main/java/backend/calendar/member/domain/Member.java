package backend.calendar.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")//다른 테이블과의 키 구분을 위해서
    private Long Id;

    @Column(nullable = false,unique = true, length=20)
    private String email;
    //비밀번호
    @Column(nullable = false,length = 30)
    private String password;
    //프로필 이미지
    @Column(nullable = true,length = 20)
    private String profileImageUrl;
    //나이
    @Column(nullable = false)
    private Integer age;

    //성별
    @Column(nullable = false)
    private String gender;

    //직업
    @Column(length = 20)
    private String job;
    //지역
    @Column(length = 20)
    private String address;
    //포인트
    @Column(nullable = false)
    private Integer point;

    public Member(String email, String password, String profileImageUrl, Integer age, String gender, String job, String address, Integer point) {
        this.email = email;
        this.password = password;
        this.profileImageUrl = "기본이미지.jpg";
        this.age = age;
        this.gender = gender;
        this.job = job;
        this.address = address;
        this.point = 0;
    }
}