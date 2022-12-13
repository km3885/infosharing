package model.bean;

import java.io.Serializable;

public class StudentCsvBean implements Serializable {
	private String id;
	private String category;
	private String name;
	private String jurisdiction;
	private String newGrad;
	private String apply;
	private String jobCard;
	private String pref;
	private String coName;
	private String internship;
	private String workAddress;
	private String empStatus;
	private String empInsurance;
	private String empperiod;
	private String empRoute;
	private String relation;
	private String position;
	private String decidedDate;

	
	public void setValue(String id, String category, String name, String jurisdiction, String newGrad, String apply, String jobCard, String pref, String coName, String internship, String workAddress, String empStatus, String empInsurance, String empperiod, String empRoute, String relation, String position, String decidedDate) {
		this.id = id;
		this.category = category;		
		this.name = name;
		this.jurisdiction = jurisdiction;
		this.newGrad = newGrad;
		this.apply = apply;
		this.jobCard = jobCard;
		this.pref = pref;
		this.coName = coName;
		this.internship = internship;
		this.workAddress = workAddress;
		this.empStatus = empStatus;
		this.empInsurance = empInsurance;
		this.empperiod = empperiod;
		this.empRoute = empRoute;
		this.relation = relation;
		this.position = position;
		this.decidedDate = decidedDate;
	}
		
	// getter/setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public String getNewGrad() {
		return newGrad;
	}
	public void setNewGrad(String newGrad) {
		this.newGrad = newGrad;
	}
	public String getApply() {
		return apply;
	}
	public void setApply(String apply) {
		this.apply = apply;
	}
	public String getJobCard() {
		return jobCard;
	}
	public void setJobCard(String jobCard) {
		this.jobCard = jobCard;
	}
	public String getPref() {
		return pref;
	}
	public void setPref(String pref) {
		this.pref = pref;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getInternship() {
		return internship;
	}
	public void setInternship(String internship) {
		this.internship = internship;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public String getEmpInsurance() {
		return empInsurance;
	}
	public void setEmpInsurance(String empInsurance) {
		this.empInsurance = empInsurance;
	}
	public String getEmpperiod() {
		return empperiod;
	}
	public void setEmpperiod(String empperiod) {
		this.empperiod = empperiod;
	}
	public String getEmpRoute() {
		return empRoute;
	}
	public void setEmpRoute(String empRoute) {
		this.empRoute = empRoute;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDecidedDate() {
		return decidedDate;
	}
	public void setDecidedDate(String decidedDate) {
		this.decidedDate = decidedDate;
	}
}
