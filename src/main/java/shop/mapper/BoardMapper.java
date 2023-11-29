package shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import shop.domain.BoardDTO;

@Mapper
public interface BoardMapper {
    public void insertBoard(BoardDTO boardDTO);
}
