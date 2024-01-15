package shop.reository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.domain.BasketDTO;
import shop.domain.JoinDTO;
import shop.domain.Member;
import shop.mapper.LoginMapper;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class LoginRepositoryV1 implements LoginRepository{
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    private EntityManager em;
    @Override
    public int insertMember(JoinDTO joinDTO){
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
        em.persist(member);
        return 1;
//        return loginMapper.join(joinDTO);
    }

    @Override
    public JoinDTO selectMember(JoinDTO joinDTO){
        Member member = new Member();
//        member= em.find(Member.class, joinDTO.getId());
        String jpql = "select i from Member i where i.id = :id and i.pw = :pw";
        member = em.createQuery(jpql, Member.class)
                .setParameter("id",joinDTO.getId())
                        .setParameter("pw", joinDTO.getPw())
                                .getSingleResult();


        joinDTO.setMemberNo((int)member.getMemberNo());
        joinDTO.setMemberName(member.getMemberName());
        joinDTO.setPhone((int)member.getPhone());
        joinDTO.setId(member.getId());
        joinDTO.setBirth((int)member.getBirth());
        joinDTO.setAddress(member.getAddress());
        joinDTO.setPw(member.getPw());
        joinDTO.setPictureOriginName(member.getPictureOriginName());
        joinDTO.setPictureUuidName(member.getPictureUuidName());





        return joinDTO;




//        return loginMapper.selectMember(joinDTO);
    }

    @Override
    public void updateMember(JoinDTO joinDTO){loginMapper.updateMember(joinDTO);}
    @Override
    public List<BasketDTO> selectBasket(JoinDTO joinDTO){return loginMapper.selectBasket(joinDTO);}

}
