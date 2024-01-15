package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shop.domain.BasketDTO;
import shop.domain.JoinDTO;
import shop.reository.LoginRepository;
import shop.reository.LoginRepositoryV2;

import java.util.List;

@Service
public class LoginServiceV1 implements LoginService {

//    LoginRepository loginRepository = new LoginRepositoryV2();
    @Autowired
    @Qualifier("loginRepositoryV1")
    LoginRepository loginRepository;
    @Override
    public int join(JoinDTO joinDTO){
        return loginRepository.insertMember(joinDTO);
    }
    @Override
    public JoinDTO selectMember(JoinDTO joinDTO){ return loginRepository.selectMember(joinDTO);}
    @Override
    public void updateMember(JoinDTO joinDTO){loginRepository.updateMember(joinDTO);}
    @Override
    public List<BasketDTO> selectBasket(JoinDTO joinDTO){return loginRepository.selectBasket(joinDTO);}
}
