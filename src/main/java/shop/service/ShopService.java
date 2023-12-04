package shop.service;

import shop.domain.ItemDTO;

import java.util.List;

public interface ShopService {
    public List<ItemDTO> selectOuter();
    public List<ItemDTO> selectTop();
    public List<ItemDTO> selectPants();
    public List<ItemDTO> selectShoes();
    public ItemDTO selectOne(ItemDTO itemDTO);
    public void updateHeart(ItemDTO itemDTO, int memberNo);
}
