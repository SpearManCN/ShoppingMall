package shop.service;

import shop.domain.BoardDTO;

import java.util.List;

public interface BoardService {
    public void insertBoard(BoardDTO boardDTO);

    public List selectAllBoard();
}
