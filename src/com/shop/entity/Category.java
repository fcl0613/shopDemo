package com.shop.entity;

public class Category {
	private Integer cateid;
	private String catename;
	private Integer parentid;
	
	
	public Category(Integer cateid, String catename, Integer parentid) {
		super();
		this.cateid = cateid;
		this.catename = catename;
		this.parentid = parentid;
	}


	/**
	 * @return the cateid
	 */
	public Integer getCateid() {
		return cateid;
	}


	/**
	 * @param cateid the cateid to set
	 */
	public void setCateid(Integer cateid) {
		this.cateid = cateid;
	}


	/**
	 * @return the catename
	 */
	public String getCatename() {
		return catename;
	}


	/**
	 * @param catename the catename to set
	 */
	public void setCatename(String catename) {
		this.catename = catename;
	}


	/**
	 * @return the parentid
	 */
	public Integer getParentid() {
		return parentid;
	}


	/**
	 * @param parentid the parentid to set
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	
	
}
