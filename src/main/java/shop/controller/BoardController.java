package shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.domain.*;
import shop.service.BoardService;
import shop.service.BoardServiceV1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/board")
    public String home(Model model, @RequestParam(value="nowPageNo",required = false, defaultValue = "1")int nowPageNo){
        List<BoardDTO> beforeResult = new ArrayList<>();
        List<BoardDTO> afterResult = new ArrayList<>();
        beforeResult = boardService.selectAllBoard();

        int totNo = beforeResult.size();//총 갯수
        int noPerPage = 10; //페이지당 나타낼 최대 글 갯수
        int zeroLast = 1; //총 갯수가 10단위인지
        if(totNo%10==0){zeroLast = 0;}
        int totPage = totNo/10 + zeroLast; //totpage는 총 페이지의 갯수( 글갯수아님)
        int startBoardNo = (nowPageNo)*10-10; //페이지당 시작글 번호
        int endBoardNo = startBoardNo +10;  //페이지당 끝 글 번호
        if(nowPageNo == totPage){endBoardNo= startBoardNo + totNo%10; }
        afterResult = beforeResult.subList(startBoardNo,endBoardNo);
        model.addAttribute("Boards", afterResult);
        List pageList = new ArrayList();
        model.addAttribute("nowPageNo", nowPageNo);
        model.addAttribute("totPage", totPage);


        return "board";
    }
/* html에서 페이지 번호를 input hidden에 넣어놓고 $(init();) 에서 controller에 있는 값을 가져와서 넣어줌
    해당 hidden값으로
    처음 -> url입력시 controller에서 기본값인 1을 넘겨줌.
    숫자를 고를때 -> 고른 숫자를 url에 같이 넘겨줘서 contoller에서 해당 숫자를 기준으로 10개를 가져다가 줌

*
*
* */
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
