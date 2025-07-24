package backend.calendar.member.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Getter
@Setter
@NoArgsConstructor
public class MemberRequest {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Size(min = 4, max = 20, message = "아이디는 4~ 20자여야 합니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Size(min = 8,message = "비밀번호는 8자 이상이어야 합니다.")
    private String password;

    private String profileImageUrl;

    private Integer age;

    private String gender;

    private String job;

    private String address;

    private Integer point;




}
