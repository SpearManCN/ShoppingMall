package shop.domain;

import lombok.Data;

@Data
public class ItemDTO {
    private int itemNo;
    private String itemName;
    private int price;
    private int sortNo;
    private int stock;
    private int heart;
}
