package shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import shop.domain.JoinDTO;

@Mapper
public interface LoginMapper {
    int join(JoinDTO joinDTO);

    JoinDTO selectMember(JoinDTO joinDTO);

    void updateMember(JoinDTO joinDTO);
}
