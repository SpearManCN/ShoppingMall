package shop.reository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.domain.JoinDTO;
import shop.mapper.LoginMapper;

@Repository
public class LoginRepositoryV1 implements LoginRepository{
    @Autowired
    LoginMapper loginMapper;
    @Override
    public int insertMember(JoinDTO joinDTO){
        return loginMapper.join(joinDTO);
    }
}
