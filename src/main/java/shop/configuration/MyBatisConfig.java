package shop.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import shop.MemberMapper;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final MemberMapper memberMapper;

}
