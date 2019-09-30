package kakao.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kakao.dao.MainMapper;
import kakao.vo.API1stVO;
import kakao.vo.API3thSubVO;
import kakao.vo.API3thVO;
import kakao.vo.DataList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainService {

    @Autowired
    private MainMapper mainMapper;

    public String get1stAPI() {
        List<API1stVO> list = mainMapper.get1stAPI();
        String result = parseJson(list);

        return result;
    }

    public String get2ndAPI() {
        List<String> year = new ArrayList<>();
        year.add("2018");
        year.add("2019");

        List<API1stVO> list = mainMapper.get2ndAPI(year);

        String result = parseJson(list);

        return result;
    }

    public String get3thAPI() {
        List<API3thSubVO> subList = mainMapper.get3rdAPI();

        Map<String, List<DataList>> map = new HashMap<>();

        List<API3thVO> list = new ArrayList<>();

        for(API3thSubVO vo : subList) {
            if(map.get(vo.getYear()) == null) {
                map.put(vo.getYear(), new ArrayList<>());
            }
            map.get(vo.getYear()).add(new DataList(vo.getBrName(), vo.getBrCode(), vo.getSumAmt()));
        }

        API3thVO api3thVO;
        for(String key : map.keySet()) {
            api3thVO = new API3thVO();
            api3thVO.setYear(key);
            api3thVO.setDataList(map.get(key));
            list.add(api3thVO);
        }

        String result = parseJson(list);

        return result;
    }

    public String get4thAPI(String code) {
        List<String> codeList = new ArrayList<>();

        if(code.equals("B")) {
            return "http status : 404 {\"code\":\"404\",\"메세지\":\"br code not found error\"}";
        } else if (code.equals("A")){
            codeList.add("B");
            codeList.add(code);
        } else {
            codeList.add(code);
        }

        List<API1stVO> list = mainMapper.get4thAPI(codeList);
        String result = parseJson(list);

        return result;
    }

    public String parseJson (Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";

        try {
            result = mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
