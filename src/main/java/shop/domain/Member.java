package shop.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Member {
    @Id
    private Integer memberNo;
    private String id;
    private String memberName;
    private Integer birth;
    private Integer phone;
    private String address;
    private String pw;
    @Column(name="pictureOriginName")
    private String pictureOriginName;
    @Column(name="pictureUuidName")
    private String pictureUuidName;
}
