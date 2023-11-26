package shop;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Mapper
public interface MemberMapper {
    void test();
    int go = 3;
    void test123();
}
