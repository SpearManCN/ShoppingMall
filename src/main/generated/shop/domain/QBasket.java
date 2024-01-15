package shop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasket is a Querydsl query type for Basket
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBasket extends EntityPathBase<Basket> {

    private static final long serialVersionUID = -1486225064L;

    public static final QBasket basket = new QBasket("basket");

    public final NumberPath<Integer> basketNo = createNumber("basketNo", Integer.class);

    public final StringPath itemName = createString("itemName");

    public final NumberPath<Integer> itemNo = createNumber("itemNo", Integer.class);

    public final NumberPath<Integer> memberNo = createNumber("memberNo", Integer.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> stock = createNumber("stock", Integer.class);

    public QBasket(String variable) {
        super(Basket.class, forVariable(variable));
    }

    public QBasket(Path<? extends Basket> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasket(PathMetadata metadata) {
        super(Basket.class, metadata);
    }

}

