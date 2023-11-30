package shop.reository;

import shop.domain.JoinDTO;

public interface LoginRepository {
    public int insertMember(JoinDTO joinDTO);
    public JoinDTO selectMember(JoinDTO joinDTO);

    public void updateMember(JoinDTO joinDTO);
}
