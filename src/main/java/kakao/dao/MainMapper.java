package kakao.dao;

import kakao.vo.API1stVO;
import kakao.vo.API3thSubVO;
import kakao.vo.API3thVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("kakao.dao.MainMapper")
public interface MainMapper {
    public String connectTest();
    public List<API1stVO> get1stAPI();
    public List<API1stVO> get2ndAPI(List<String> year);
    public List<API3thSubVO> get3rdAPI();
    public List<API1stVO> get4thAPI(List<String> brName);
}
