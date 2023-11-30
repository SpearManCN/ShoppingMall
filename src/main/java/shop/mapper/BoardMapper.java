package shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import shop.domain.BoardDTO;

import java.util.List;

@Mapper
public interface BoardMapper {
    public void insertBoard(BoardDTO boardDTO);

    public List selectAllBoard();
}
