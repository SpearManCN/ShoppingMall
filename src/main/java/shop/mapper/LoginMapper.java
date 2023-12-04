package shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import shop.domain.BasketDTO;
import shop.domain.JoinDTO;

import java.util.List;

@Mapper
public interface LoginMapper {
    int join(JoinDTO joinDTO);

    JoinDTO selectMember(JoinDTO joinDTO);

    void updateMember(JoinDTO joinDTO);

    List<BasketDTO> selectBasket(JoinDTO joinDTO);
}
