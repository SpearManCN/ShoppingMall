package shop.reository;

import shop.mapper.BoardMapper;
import shop.domain.BoardDTO;


public interface BoardRepository {
    public void insertBoard(BoardDTO boardDTO);
}
