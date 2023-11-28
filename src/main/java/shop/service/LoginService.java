package shop.service;

import org.apache.tomcat.Jar;
import shop.domain.JoinDTO;

public interface LoginService {
    public int join(JoinDTO joinDTO);
}
