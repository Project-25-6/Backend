package backend.calendar.goal.dto.request;


import backend.calendar.goal.domain.enums.GoalDifficulty;
import backend.calendar.goal.domain.enums.GoalType;
import backend.calendar.member.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class GoalRequest {

    private Long goalId;

    private Long memberId;


    @NotBlank(message = "목표 이름은 필수입니다.")
    private String goalName;

    @NotNull(message = "목표 마감일은 필수입니다.")
    private LocalDate dueDate;

    @NotNull(message = "목표 난이도는 필수입니다.")
    private GoalDifficulty goalDifficulty;

    @NotNull(message = "목표 타입은 필수입니다.")
    private GoalType goalType;



}
