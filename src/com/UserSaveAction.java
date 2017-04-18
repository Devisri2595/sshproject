
package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


public class UserSaveAction extends DispatchAction{
	
	public ActionForward Create(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserService userservice = (UserService) ServiceFinder.getContext(request).getBean("userservice");
		UserForm userForm = (UserForm) form;
		UserBean userbean = new UserBean();
		userbean.setMonth(userForm.getMonth());
		userbean.setProjectname(userForm.getProjectname());
		userbean.setPrjectid(userForm.getPrjectid());
		userbean.setProjectdetail(userForm.getProjectdetail());
		userbean.setCreated(userForm.getCreated());
		userbean.setStratdate(userForm.getStratdate());
		userbean.setEnddate(userForm.getEnddate());
		userbean.setStatus(userForm.getStatus());

		userservice.saveUser(userbean);
	  	 
	  return mapping.findForward("success");
	 }
	
	public ActionForward Update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserService userservice = (UserService) ServiceFinder.getContext(request).getBean("userservice");
		UserForm userForm = (UserForm) form;
		UserBean userbean = new UserBean();
		userbean.setMonth(userForm.getMonth());
		userbean.setProjectname(userForm.getProjectname());
		userbean.setPrjectid(userForm.getPrjectid());
		userbean.setUserId(userForm.getPrjectid());
		userbean.setProjectdetail(userForm.getProjectdetail());
		userbean.setCreated(userForm.getCreated());
		userbean.setStratdate(userForm.getStratdate());
		userbean.setEnddate(userForm.getEnddate());
		userbean.setStatus(userForm.getStatus());

		userservice.updateUser(userbean);
	  	 
	  return mapping.findForward("success");
	 }
	
	public ActionForward Delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserService userservice = (UserService) ServiceFinder.getContext(request).getBean("userservice");
		UserForm userForm = (UserForm) form;
		UserBean userbean = new UserBean();
		
		userbean.setUserId(userForm.getPrjectid());
		userservice.DeleteUser(userbean);
		
		
		 return mapping.findForward("success");
	}
	
	
	

}
