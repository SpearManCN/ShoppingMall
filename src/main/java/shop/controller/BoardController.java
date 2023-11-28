package shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    @RequestMapping("/board")
    public String home(Model model){
        return "board";
    }

    @RequestMapping("/board_write")
    public String write(Model model){
        return "board_write";
    }
}
