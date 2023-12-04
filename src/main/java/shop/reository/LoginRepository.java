package shop.reository;

import shop.domain.BasketDTO;
import shop.domain.JoinDTO;

import java.util.List;

public interface LoginRepository {
    public int insertMember(JoinDTO joinDTO);
    public JoinDTO selectMember(JoinDTO joinDTO);

    public void updateMember(JoinDTO joinDTO);
    public List<BasketDTO> selectBasket(JoinDTO joinDTO);
}
