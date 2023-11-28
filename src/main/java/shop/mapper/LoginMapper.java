package shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import shop.domain.JoinDTO;

@Mapper
public interface LoginMapper {
    int join(JoinDTO joinDTO);
}
