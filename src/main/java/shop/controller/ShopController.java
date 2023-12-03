package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.domain.ItemDTO;
import shop.service.ShopService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    ShopService shopService;
    @RequestMapping("/shop")
    public String home(Model model){
        List<ItemDTO> result = new ArrayList<>();
        result = shopService.selectOuter();
        model.addAttribute("items", result);
        return "shop_outer";

    }
    @RequestMapping("/shop_top")
    public String top(Model model){
        List<ItemDTO> result = new ArrayList<>();
        result = shopService.selectTop();
        model.addAttribute("items", result);
        return "shop_top";

    }
    @RequestMapping("/shop_pants")
    public String pants(Model model){
        List<ItemDTO> result = new ArrayList<>();
        result = shopService.selectPants();
        model.addAttribute("items", result);
        return "shop_pants";

    }
    @RequestMapping("/shop_shoes")
    public String shoes(Model model){
        List<ItemDTO> result = new ArrayList<>();
        result = shopService.selectShoes();
        model.addAttribute("items", result);
        return "shop_shoes";

    }
    @RequestMapping("/shop_detail")
    public String detail(Model model){

        return "shop_detail";
    }
}
