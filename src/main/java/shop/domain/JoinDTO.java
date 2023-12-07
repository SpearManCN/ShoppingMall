package shop.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class JoinDTO {
    private int memberNo;
    private String id;
    private String memberName;
    private int birth;
    private int phone;
    private String address;
    private String pw;
    private String pictureOriginName;
    private String pictureUuidName;
    private MultipartFile fileName;
}
