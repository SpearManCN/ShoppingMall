package shop.domain;

import lombok.Data;

@Data
public class BoardDTO {
    private int boardNo;
    private int memberNo;
    private String title;
    private String content;
}
