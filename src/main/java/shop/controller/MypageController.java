package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.domain.JoinDTO;
import shop.service.LoginService;

@Controller
public class MypageController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/mypage")
    public String home(Model model){
        return "mypage";
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping("/join")
    public String join(Model model){
        return "join";
    }

    @RequestMapping("/joinProc")
    @ResponseBody
    public int joinProc(JoinDTO joinDTO){
        return loginService.join(joinDTO);
    }
}
