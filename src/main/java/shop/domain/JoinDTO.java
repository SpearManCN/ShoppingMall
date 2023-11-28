package shop.domain;

import lombok.Data;

@Data
public class JoinDTO {
    private String id;
    private String memberName;
    private int birth;
    private int phone;
    private String address;
    private String pw;

}
