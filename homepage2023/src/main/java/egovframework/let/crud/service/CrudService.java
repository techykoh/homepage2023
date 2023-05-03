package egovframework.let.crud.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface CrudService {
	
	// 1.CRUD 가져오기
	public CrudVO selectCrud(CrudVO vo) throws Exception;
	
	// 2.CRUD 등록하기
	public String insertCrud(CrudVO vo) throws Exception;
	
	// 3.CRUD 목록 가져오기
	public List<EgovMap> selectCrudList(CrudVO vo) throws Exception;
	
	// 4.CRUD 목록 수
	public int selectCrudListCnt(CrudVO vo) throws Exception;
	
	// 5.CURD 수정하기
	public void updateCrud(CrudVO vo) throws Exception;
	
	// 6.CRUD 삭제하기
	public void deleteCrud(CrudVO vo) throws Exception;
}
