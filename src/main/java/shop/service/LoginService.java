package shop.service;

import org.apache.tomcat.Jar;
import shop.domain.BasketDTO;
import shop.domain.JoinDTO;

import java.util.List;

public interface LoginService {
    public int join(JoinDTO joinDTO);
    public JoinDTO selectMember(JoinDTO joinDTO);

    public void updateMember(JoinDTO joinDTO);
    public List<BasketDTO> selectBasket(JoinDTO joinDTO);
}
