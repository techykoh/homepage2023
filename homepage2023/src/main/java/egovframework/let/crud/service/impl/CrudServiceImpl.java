package egovframework.let.crud.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.crud.service.CrudService;
import egovframework.let.crud.service.CrudVO;
import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("crudService")
public class CrudServiceImpl extends EgovAbstractServiceImpl implements CrudService {
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	@Resource(name = "crudMapper")
	private CrudMapper crudMapper;
	
	@Resource(name = "egovCrudIdGnrService")
	private EgovIdGnrService idgenService;

	// 1. CRUD 등록하기
	public String insertCrud(CrudVO vo) throws Exception {
		String id = idgenService.getNextStringId();
		vo.setCrudID(id);
		crudMapper.insertCrud(vo);
		
		return id;
	}
	// 2. CRUD 목록 가져오기
	public List<EgovMap> selectCrudList(CrudVO vo) throws Exception {
		return crudMapper.selectCrudList(vo);
	}
	// 3. CRUD 목록 수
	public int selectCrudListCnt(CrudVO vo) throws Exception {
		return crudMapper.selectCrudListCnt(vo);
	}
	// 4. CRUD 가져오기
	public CrudVO selectCrud(CrudVO vo) throws Exception {
		return crudMapper.selectCrud(vo);
	}
	// 5. CRUD 수정하기
	public void updateCrud(CrudVO vo) throws Exception {
		crudMapper.updateCrud(vo);
	}
	// 6. CRUD 삭제하기
	public void deleteCrud(CrudVO vo) throws Exception {
		crudMapper.deleteCrud(vo);
	}
	
}
