package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.domain.JoinDTO;
import shop.reository.LoginRepository;

@Service
public class LoginServiceV1 implements LoginService {
    @Autowired
    LoginRepository loginRepository;
    @Override
    public int join(JoinDTO joinDTO){
        return loginRepository.insertMember(joinDTO);
    }
    @Override
    public JoinDTO selectMember(JoinDTO joinDTO){ return loginRepository.selectMember(joinDTO);}
}
