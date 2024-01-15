package shop.reository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.domain.BasketDTO;
import shop.domain.JoinDTO;
import shop.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public interface SpringDataRepository extends JpaRepository<Member, Long> {

    public Member save(Member member);
    public Member findByIdAndPw(String id, String pw);
    @Modifying
    @Transactional
    @Query("UPDATE Member m set m.pw = :pw where m.id = :id")
    public void updatePwById(@Param("pw") String pw, @Param("id") String id);
}
