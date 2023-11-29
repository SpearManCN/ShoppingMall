package shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.domain.*;
import shop.service.BoardService;
import shop.service.BoardServiceV1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/board")
    public String home(Model model){
        return "board";
    }

    @RequestMapping("/board_write")
    public String write(Model model){
        return "board_write";
    }

    @RequestMapping("/board_writeProc")
    @ResponseBody
    public void writeProc(BoardDTO boardDTO, HttpServletRequest request){
        HttpSession session = request.getSession();
        JoinDTO joinDTO = (JoinDTO) session.getAttribute("user");
        boardDTO.setMemberNo(joinDTO.getMemberNo());
        boardService.insertBoard(boardDTO);
    }
}
