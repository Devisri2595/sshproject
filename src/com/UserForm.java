
package com;

import org.apache.struts.action.ActionForm;


public class UserForm extends ActionForm{
	
	String month;
	String projectname;
	int prjectid;
	String projectdetail;
	String created;
	String stratdate;
	String enddate;
	String status;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public int getPrjectid() {
		return prjectid;
	}
	public void setPrjectid(int prjectid) {
		this.prjectid = prjectid;
	}
	public String getProjectdetail() {
		return projectdetail;
	}
	public void setProjectdetail(String projectdetail) {
		this.projectdetail = projectdetail;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getStratdate() {
		return stratdate;
	}
	public void setStratdate(String stratdate) {
		this.stratdate = stratdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
