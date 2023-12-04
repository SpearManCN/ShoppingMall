package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.domain.BasketDTO;
import shop.domain.ItemDTO;
import shop.reository.ShopRepository;

import java.util.List;

@Transactional
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
    public void clickHeart(BasketDTO basketDTO){shopRepository.insertBasket(basketDTO);shopRepository.updateHeart(basketDTO);}
    @Override
    public void updateHeart(BasketDTO basketDTO){shopRepository.updateHeart(basketDTO);}
    @Override
    public void insertBasket(BasketDTO basketDTO){shopRepository.insertBasket(basketDTO);}
}
