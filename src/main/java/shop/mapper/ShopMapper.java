package shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import shop.domain.ItemDTO;

import java.util.List;

@Mapper
public interface ShopMapper {
    public List<ItemDTO> selectOuter();
    public List<ItemDTO> selectTop();
    public List<ItemDTO> selectPants();
    public List<ItemDTO> selectShoes();

}
