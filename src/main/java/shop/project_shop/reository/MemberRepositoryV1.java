package shop.project_shop.reository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.project_shop.MemberMapper;

@Repository
public class MemberRepositoryV1 implements MemberRepository{
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public void insertMember(){
        memberMapper.test();
    }
}
