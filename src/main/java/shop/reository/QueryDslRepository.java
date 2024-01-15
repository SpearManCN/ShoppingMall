package shop.reository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.domain.*;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class QueryDslRepository {

    @Autowired
    private EntityManager em;
    @Autowired
    private JPAQueryFactory query;

    public List<BasketDTO> selectBasket(JoinDTO joinDTO) {
        QBasket basket = QBasket.basket;
        QItem item = QItem.item;

        return query
                .select(
                        Projections.bean(
                            BasketDTO.class,
                            basket.basketNo,
                            basket.itemNo,
                            basket.memberNo,
                            item.itemName,
                            item.price,
                            item.stock
                        )
                )
                .from(basket)
                .join(item).on(basket.itemNo.eq(item.itemNo))
                .where(basket.memberNo.eq(joinDTO.getMemberNo()))
                .fetch();
    }

//    <select id="selectBasket" resultType="BasketDTO">
//    select a.basketNo, a.itemNo, a.memberNo, b.itemName, b.price, b.stock
//    from basket a Inner JOIN item b on a.itemNo = b.itemNo
//    where a.memberNo = #{memberNo}
//    </select>
}
