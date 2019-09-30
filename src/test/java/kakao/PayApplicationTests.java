package kakao;

import com.fasterxml.jackson.databind.ObjectMapper;
import kakao.dao.MainMapper;
import kakao.vo.API1stVO;
import kakao.vo.API3thSubVO;
import kakao.vo.API3thVO;
import kakao.vo.DataList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayApplicationTests {

	@Autowired
	private MainMapper mainMapper;

	@Test
	public void connectTest() {
		String result = mainMapper.connectTest();

		System.out.println(result);
	}

	@Test
	public void get1stAPI() {
		List<API1stVO> list = mainMapper.get1stAPI();
		ObjectMapper mapper = new ObjectMapper();
		String result = "";

		try {
			result = mapper.writeValueAsString(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(result);
	}

	@Test
	public void get2ndAPI() {
		List<String> year = new ArrayList<>();
		year.add("2018");
		year.add("2019");

		List<API1stVO> list = mainMapper.get2ndAPI(year);
		ObjectMapper mapper = new ObjectMapper();
		String result = "";

		try {
			result = mapper.writeValueAsString(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(result);
	}

	@Test
	public void get3rdAPI() {
		List<API3thSubVO> subList = mainMapper.get3rdAPI();

		Map<String, List<DataList>> map = new HashMap<>();

		List<API3thVO> list = new ArrayList<>();

		for(API3thSubVO vo : subList) {
			if(map.get(vo.getYear()) == null) {
				map.put(vo.getYear(), new ArrayList<>());
			}
			map.get(vo.getYear()).add(new DataList(vo.getBrName(), vo.getBrName(), vo.getSumAmt()));
		}

		API3thVO api3thVO;
		for(String key : map.keySet()) {
			api3thVO = new API3thVO();
			api3thVO.setYear(key);
			api3thVO.setDataList(map.get(key));
			list.add(api3thVO);
		}

		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(result);
	}

	@Test
	public void get4thAPI() {
		List<String> brName = new ArrayList<>();
		brName.add("판교점");
		brName.add("분당점");
		List<API1stVO> list = mainMapper.get4thAPI(brName);
		ObjectMapper mapper = new ObjectMapper();
		String result = "";

		try {
			result = mapper.writeValueAsString(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(result);
	}

}
