package shop.reository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import shop.domain.BasketDTO;
import shop.domain.JoinDTO;
import shop.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class LoginRepositoryV2 implements LoginRepository {


    @Autowired
    private EntityManager em;
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
    };
    public JoinDTO selectMember(JoinDTO joinDTO){
        JoinDTO result = em.find(JoinDTO.class, joinDTO.getId());
        return result;
    };

    public void updateMember(JoinDTO joinDTO){
        JoinDTO result = em.find(JoinDTO.class, joinDTO.getId());
        result.setPw(joinDTO.getPw());
    };
    public List<BasketDTO> selectBasket(JoinDTO joinDTO){
        return null;
    };
}
