package shop.reository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.domain.ItemDTO;
import shop.mapper.ShopMapper;

import java.util.List;

@Repository
public class ShopRepositoryV1 implements ShopRepository{
    @Autowired
    ShopMapper shopMapper;
    @Override
    public List<ItemDTO> selectOuter(){return shopMapper.selectOuter();}
    @Override
    public List<ItemDTO> selectTop(){return shopMapper.selectTop();}
    @Override
    public List<ItemDTO> selectPants(){return shopMapper.selectPants();}
    @Override
    public List<ItemDTO> selectShoes(){return shopMapper.selectShoes();}
}
