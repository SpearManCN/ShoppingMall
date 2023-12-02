package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.domain.BoardDTO;
import shop.reository.BoardRepository;

import java.util.List;

@Service
public class BoardServiceV1 implements BoardService{
    @Autowired
    BoardRepository boardRepository;
    @Override
    public void insertBoard(BoardDTO boardDTO){
        boardRepository.insertBoard(boardDTO);
    }
    @Override
    public List selectAllBoard(){
        return boardRepository.selectAllBoard();
    }

    @Override
    public BoardDTO selectOneBoard(BoardDTO boardDTO){return boardRepository.selectOneBoard(boardDTO);}
}
