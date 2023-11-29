package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.domain.JoinDTO;
import shop.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @RequestMapping("loginProc")
    @ResponseBody
    public int loginProc(JoinDTO joinDTO, Model model, HttpServletRequest request){
        JoinDTO searchResult = new JoinDTO();
        searchResult = loginService.selectMember(joinDTO);

        if(searchResult == null){
            return 0;
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("user", searchResult);
            return 1;
        }


    }



}
