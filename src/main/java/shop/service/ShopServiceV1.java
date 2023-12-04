package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.domain.ItemDTO;
import shop.reository.ShopRepository;

import java.util.List;

@Service
public class ShopServiceV1 implements ShopService {
    @Autowired
    ShopRepository shopRepository;
    @Override
    public List<ItemDTO> selectOuter(){
        return shopRepository.selectOuter();
    }
    @Override
    public List<ItemDTO> selectTop(){
        return shopRepository.selectTop();
    }
    @Override
    public List<ItemDTO> selectPants(){
        return shopRepository.selectPants();
    }
    @Override
    public List<ItemDTO> selectShoes(){
        return shopRepository.selectShoes();
    }
    @Override
    public ItemDTO selectOne(ItemDTO itemDTO){return shopRepository.selectOne(itemDTO);}
    @Override
    public void updateHeart(ItemDTO itemDTO, int memberNo){shopRepository.updateHeart(itemDTO,memberNo);}
}
