package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shop.domain.BasketDTO;
import shop.domain.JoinDTO;
import shop.domain.Member;
import shop.reository.LoginRepository;
import shop.reository.LoginRepositoryV2;
import shop.reository.QueryDslRepository;
import shop.reository.SpringDataRepository;

import java.util.List;
@Service
public class LoginServiceV2 implements LoginService{
    @Autowired
    @Qualifier("loginRepositoryV1")
    LoginRepository loginRepository;
    @Autowired
    SpringDataRepository repository;
    @Autowired
    QueryDslRepository queryDslRepository;
    @Override
    public int join(JoinDTO joinDTO){
        Member member = new Member();
        member.setMemberNo(joinDTO.getMemberNo());
        member.setMemberName(joinDTO.getMemberName());
        member.setPhone(joinDTO.getPhone());
        member.setId(joinDTO.getId());
        member.setBirth(joinDTO.getBirth());
        member.setAddress(joinDTO.getAddress());
        member.setPw(joinDTO.getPw());
        member.setPictureOriginName(joinDTO.getPictureOriginName());
        member.setPictureUuidName(joinDTO.getPictureUuidName());
        return 1;
    }
    @Override
    public JoinDTO selectMember(JoinDTO joinDTO){
        Member member = new Member();

        member = repository.findByIdAndPw(joinDTO.getId(),joinDTO.getPw() );
        joinDTO.setMemberNo(member.getMemberNo());
        joinDTO.setMemberName(member.getMemberName());
        joinDTO.setPhone(member.getPhone());
        joinDTO.setId(member.getId());
        joinDTO.setBirth(member.getBirth());
        joinDTO.setAddress(member.getAddress());
        joinDTO.setPw(member.getPw());
        joinDTO.setPictureOriginName(member.getPictureOriginName());
        joinDTO.setPictureUuidName(member.getPictureUuidName());
        return joinDTO;
    }



    @Override
    public void updateMember(JoinDTO joinDTO){
        repository.updatePwById(joinDTO.getPw(),joinDTO.getId());
    }
    @Override
    public List<BasketDTO> selectBasket(JoinDTO joinDTO){
        return queryDslRepository.selectBasket(joinDTO);
//        return loginRepository.selectBasket(joinDTO);
    }


//    @Override
//    public JoinDTO selectMember(JoinDTO joinDTO){ return loginRepository.selectMember(joinDTO);}
//    @Override
//    public void updateMember(JoinDTO joinDTO){loginRepository.updateMember(joinDTO);}
//    @Override
//    public List<BasketDTO> selectBasket(JoinDTO joinDTO){return loginRepository.selectBasket(joinDTO);}

}
