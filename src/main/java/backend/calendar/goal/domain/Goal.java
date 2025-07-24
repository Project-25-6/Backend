package backend.calendar.goal.domain;

import backend.calendar.goal.domain.enums.GoalDifficulty;
import backend.calendar.goal.domain.enums.GoalType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long id;

    @Column(nullable = false, length = 30)
    private String goalName;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean achievement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GoalType goalType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GoalDifficulty goalDifficulty;

    @Column(nullable = false)
    private LocalDate dueDate;

}
