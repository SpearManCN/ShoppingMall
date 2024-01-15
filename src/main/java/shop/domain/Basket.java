package shop.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class Basket {
    @Id
    private Integer basketNo;
    private Integer memberNo;
    private Integer itemNo;
    private String itemName;
    private Integer price;
    private Integer stock;
}
