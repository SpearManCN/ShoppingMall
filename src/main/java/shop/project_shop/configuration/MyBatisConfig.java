package shop.project_shop.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.project_shop.MemberMapper;
import shop.project_shop.reository.MemberRepository;
import shop.project_shop.reository.MemberRepositoryV1;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final MemberMapper memberMapper;

}
