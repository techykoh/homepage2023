package egovframework.let.temp.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;


// controller란 ? jsp에 값을 주는 역할을 한다.
@Controller
public class TempController {
	
	@Resource(name = "tempService")
	private TempService tempService;
	
	// 임시데이터 가져오기 (PK값을 이용해서 하나의 값을 가져오기)
	@RequestMapping(value = "/temp/select.do")
	public String select(TempVO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		// HttpServletRequest 
		// model : 'java에서 만든 것을 jsp에서 쓰겠다' 선언한 것
		TempVO result = tempService.selectTemp(tempVO);
		model.addAttribute("result", result);
		return "temp/TempSelect"; // jsp 위치 경로
	}
	
	
	// 임시데이터 목록 가져오기
	@RequestMapping(value = "/temp/selectList.do")
	public String selectList(TempVO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		// List : java.util.List
		List<EgovMap> resultList = tempService.selectTempList(tempVO);
		model.addAttribute("resultList", resultList);
		
		return "temp/TempSelectList";
	}
	
	
	// 임시데이터 등록/수정
	@RequestMapping(value = "/temp/tempRegist.do")
	public String tempRegist(TempVO tempVO, HttpServletRequest request, ModelMap model) throws Exception {
		TempVO result = new TempVO();
		// egovframework.let.utl.fcc.service.EgovStringUtil import하세요.
		if(!EgovStringUtil.isEmpty(tempVO.getTempId())) { // PK값이 있나요?
			result = tempService.selectTemp(tempVO); // PK값이 있다면, result에 그 값을 담아주세요.
		}
		model.addAttribute("result", result); // PK값이 없으면 result는 기본값으로 세팅하세요.
		
		return "temp/TempRegist";
	}
	
	
	// 임시데이터 등록하기
	@RequestMapping(value = "/temp/insert.do")
	public String insert(TempVO tempVO, HttpServletRequest request) throws Exception {
		tempService.insertTemp(tempVO);
		
		return "forward:/temp/selectList.do";
	}

}
