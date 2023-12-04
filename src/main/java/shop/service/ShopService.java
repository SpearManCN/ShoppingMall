package shop.service;

import shop.domain.BasketDTO;
import shop.domain.ItemDTO;

import java.util.List;

public interface ShopService {
    public List<ItemDTO> selectOuter();
    public List<ItemDTO> selectTop();
    public List<ItemDTO> selectPants();
    public List<ItemDTO> selectShoes();
    public ItemDTO selectOne(ItemDTO itemDTO);

    public void clickHeart(BasketDTO basketDTO);
    public void updateHeart(BasketDTO basketDTO);
    public void insertBasket(BasketDTO basketDTO);
}
