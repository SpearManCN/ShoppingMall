package shop.reository;

import shop.domain.ItemDTO;

import java.util.List;

public interface ShopRepository {
    public List<ItemDTO> selectOuter();
    public List<ItemDTO> selectTop();
    public List<ItemDTO> selectPants();
    public List<ItemDTO> selectShoes();
}
