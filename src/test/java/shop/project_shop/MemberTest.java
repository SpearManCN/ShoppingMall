package shop.project_shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {
//    @Autowired
//    MemberService memberService;
    @Autowired
    MemberMapper mapper;
    @Test
    public void test(){
        mapper.test();

    }
}
