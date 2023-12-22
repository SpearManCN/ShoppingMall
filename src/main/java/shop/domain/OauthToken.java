package shop.domain;

import lombok.Data;

@Data
public class OauthToken {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expires_in;
    private String refresh_token_expires_in;
    private String scope;

}
