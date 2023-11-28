package shop;

import org.assertj.core.condition.Join;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.domain.JoinDTO;
import shop.service.LoginService;
import shop.service.MemberService;

@SpringBootTest
public class MemberTest {
    @Autowired
    MemberService memberService;
    @Autowired
    LoginService loginService;
//    @Autowired
//    MemberMapper mapper;
    @Test
    public void test(){
        JoinDTO dto = new JoinDTO();
        dto.setAddress("1");
        dto.setBirth(1);
        dto.setPw("2");
        dto.setId("1");
        dto.setPhone(1);
        dto.setMemberName("1");
        System.out.println(loginService.join(dto));
//        memberService.test();
//        mapper.test();
//        System.out.println(mapper.go);

    }
}
