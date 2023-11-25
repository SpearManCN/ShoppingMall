package shop.project_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.project_shop.reository.MemberRepository;

@Service
public class MemberServiceV1 implements MemberService{
    @Autowired
    MemberRepository memberRepository;
    public void test(){memberRepository.insertMember();}
}
