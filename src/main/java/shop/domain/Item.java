package shop.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Item {
    @Id
    private Integer itemNo;
    private String itemName;
    private Integer price;
    private Integer sortNo;
    private Integer stock;
    private Integer heart;
}
