package egovframework.let.crud.service;

import java.io.Serializable;

import egovframework.com.cmm.ComDefaultVO;

public class CrudVO extends ComDefaultVO implements Serializable{
	
	// CRUD ID
	private String crudID;
	
	// 제목
	private String crudsj;
	
	// 내용
	private String crudCn;
	
	// 작성자
	private String userNm;
	
	// 작성일
	private java.util.Date frstRegistPnttm;

	// getter & setter (Alt + Shift + S , R)
	public String getCrudID() {
		return crudID;
	}

	public void setCrudID(String crudID) {
		this.crudID = crudID;
	}

	public String getCrudsj() {
		return crudsj;
	}

	public void setCrudsj(String crudsj) {
		this.crudsj = crudsj;
	}

	public String getCrudCn() {
		return crudCn;
	}

	public void setCrudCn(String crudCn) {
		this.crudCn = crudCn;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public java.util.Date getFrstRegistPnttm() {
		return frstRegistPnttm;
	}

	public void setFrstRegistPnttm(java.util.Date frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}
	
}
