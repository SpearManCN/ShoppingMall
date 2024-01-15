package shop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1167797716L;

    public static final QMember member = new QMember("member1");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> birth = createNumber("birth", Integer.class);

    public final StringPath id = createString("id");

    public final StringPath memberName = createString("memberName");

    public final NumberPath<Integer> memberNo = createNumber("memberNo", Integer.class);

    public final NumberPath<Integer> phone = createNumber("phone", Integer.class);

    public final StringPath pictureOriginName = createString("pictureOriginName");

    public final StringPath pictureUuidName = createString("pictureUuidName");

    public final StringPath pw = createString("pw");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

