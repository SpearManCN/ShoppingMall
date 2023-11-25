package shop.project_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageController {
    @RequestMapping("/mypage")
    public String home(Model model){
        return "mypage";

    }
}
