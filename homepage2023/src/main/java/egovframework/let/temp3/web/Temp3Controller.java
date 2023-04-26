package egovframework.let.temp3.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.temp3.service.Temp3Service;
import egovframework.let.temp3.service.Temp3VO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


// controller란 ? jsp에 값을 주는 역할을 한다.
@Controller
public class Temp3Controller {
	
	@Resource(name = "temp3Service")
	private Temp3Service temp3Service;
	
	// 임시데이터 가져오기 (PK값을 이용해서 하나의 값을 가져오기)
	@RequestMapping(value = "/temp3/select.do")
	public String select(Temp3VO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		// HttpServletRequest 
		// model : 'java에서 만든 것을 jsp에서 쓰겠다' 선언한 것
		Temp3VO result = temp3Service.selectTemp(tempVO);
		model.addAttribute("result", result);
		return "temp3/TempSelect"; // jsp 위치 경로
	}
	
	
	// 임시데이터 목록 가져오기
	@RequestMapping(value = "/temp3/selectList.do")
	public String selectList(Temp3VO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(tempVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(tempVO.getPageUnit());
		paginationInfo.setPageSize(tempVO.getPageSize());
		
		tempVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		tempVO.setLastIndex(paginationInfo.getLastRecordIndex());
		tempVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		int totCnt = temp3Service.selectTempListCnt(tempVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		// List : java.util.List
		List<EgovMap> resultList = temp3Service.selectTempList(tempVO);
		model.addAttribute("resultList", resultList);
		
		return "temp3/TempSelectList";
	}
	
	
	// 임시데이터 등록/수정
	@RequestMapping(value = "/temp3/tempRegist.do")
	public String tempRegist(Temp3VO tempVO, HttpServletRequest request, ModelMap model) throws Exception {
		Temp3VO result = new Temp3VO();
		// egovframework.let.utl.fcc.service.EgovStringUtil import하세요.
		if(!EgovStringUtil.isEmpty(tempVO.getTempId())) { // PK값이 있나요?
			result = temp3Service.selectTemp(tempVO); // PK값이 있다면, result에 그 값을 담아주세요.
		}
		model.addAttribute("result", result); // PK값이 없으면 result는 기본값으로 세팅하세요.
		
		return "temp3/TempRegist";
	}
	
	
	// 임시데이터 등록하기
	@RequestMapping(value = "/temp3/insert.do")
	public String insert(Temp3VO tempVO, HttpServletRequest request) throws Exception {
		temp3Service.insertTemp(tempVO);
		
		return "forward:/temp3/selectList.do";
	}
	
	
	// 임시데이터 수정하기
	@RequestMapping(value = "/temp3/update.do")
	public String update(Temp3VO tempVO, HttpServletRequest request) throws Exception {
		temp3Service.updateTemp(tempVO);
		return "forward:/temp3/selectList.do";
	}

	
	// 임시데이터 삭제하기
	@RequestMapping(value = "/temp3/delete.do")
	public String delete(Temp3VO tempVO, HttpServletRequest request) throws Exception {
		temp3Service.deleteTemp(tempVO);
		return "forward:/temp3/selectList.do";
	}
}

