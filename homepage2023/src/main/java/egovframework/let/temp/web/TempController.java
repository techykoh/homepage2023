package egovframework.let.temp.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;


// controller란 ? jsp에 값을 주는 역할을 한다.
@Controller
public class TempController {
	
	@Resource(name = "tempService")
	private TempService tempService;
	
	// 임시데이터 가져오기
	@RequestMapping(value = "/temp/select.do")
	public String select(TempVO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		// HttpServletRequest 
		// model : 'java에서 만든 것을 jsp에서 쓰겠다' 선언한 것
		TempVO result = tempService.selectTemp(tempVO);
		model.addAttribute("result", result);
		return "temp/TempSelect"; // jsp 위치 경로
	}

}
