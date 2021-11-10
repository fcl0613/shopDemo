package com.shop.entity;

public class Products {
	private Integer proid;
	private String proname;
	private String prodes;
	private float propice;
	private float prostock;
	private Integer profcateid;
	private Integer proccateid;
	private String propicname;
	
	
	
	public Products(Integer proid, String proname, String prodes, float propice, float prostock, Integer profcateid,
			Integer proccateid, String propicname) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.prodes = prodes;
		this.propice = propice;
		this.prostock = prostock;
		this.profcateid = profcateid;
		this.proccateid = proccateid;
		this.propicname = propicname;
	}
	/**
	 * @return the proid
	 */
	public Integer getProid() {
		return proid;
	}
	/**
	 * @param proid the proid to set
	 */
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	/**
	 * @return the proname
	 */
	public String getProname() {
		return proname;
	}
	/**
	 * @param proname the proname to set
	 */
	public void setProname(String proname) {
		this.proname = proname;
	}
	/**
	 * @return the prodes
	 */
	public String getProdes() {
		return prodes;
	}
	/**
	 * @param prodes the prodes to set
	 */
	public void setProdes(String prodes) {
		this.prodes = prodes;
	}
	/**
	 * @return the propice
	 */
	public float getPropice() {
		return propice;
	}
	/**
	 * @param propice the propice to set
	 */
	public void setPropice(float propice) {
		this.propice = propice;
	}
	/**
	 * @return the prostock
	 */
	public float getProstock() {
		return prostock;
	}
	/**
	 * @param prostock the prostock to set
	 */
	public void setProstock(float prostock) {
		this.prostock = prostock;
	}
	/**
	 * @return the profcateid
	 */
	public Integer getProfcateid() {
		return profcateid;
	}
	/**
	 * @param profcateid the profcateid to set
	 */
	public void setProfcateid(Integer profcateid) {
		this.profcateid = profcateid;
	}
	/**
	 * @return the proccateid
	 */
	public Integer getProccateid() {
		return proccateid;
	}
	/**
	 * @param proccateid the proccateid to set
	 */
	public void setProccateid(Integer proccateid) {
		this.proccateid = proccateid;
	}
	/**
	 * @return the propicname
	 */
	public String getPropicname() {
		return propicname;
	}
	/**
	 * @param propicname the propicname to set
	 */
	public void setPropicname(String propicname) {
		this.propicname = propicname;
	}
	
	
}
