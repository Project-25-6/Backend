package backend.calendar.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    //test
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }
}
