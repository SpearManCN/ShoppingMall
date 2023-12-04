package shop.domain;

import lombok.Data;

@Data
public class BasketDTO {
    private int basketNo;
    private int memberNo;
    private int itemNo;
    private String itemName;
    private int price;
    private int stock;
}
