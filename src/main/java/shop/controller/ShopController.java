package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {
    @RequestMapping("/shop")
    public String home(Model model){
        return "shop_outer";

    }
    @RequestMapping("/shop_top")
    public String top(Model model){
        return "shop_top";

    }
    @RequestMapping("/shop_pants")
    public String pants(Model model){
        return "shop_pants";

    }
    @RequestMapping("/shop_shoes")
    public String shoes(Model model){
        return "shop_shoes";

    }
}
