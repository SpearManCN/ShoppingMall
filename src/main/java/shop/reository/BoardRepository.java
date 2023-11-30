package shop.reository;

import shop.mapper.BoardMapper;
import shop.domain.BoardDTO;

import java.util.List;


public interface BoardRepository {
    public void insertBoard(BoardDTO boardDTO);

    public List<BoardDTO> selectAllBoard();
}
