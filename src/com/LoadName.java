package com;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoadName extends Action {

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		
		UserService userservice = (UserService) ServiceFinder.getContext(request).getBean("userservice");
		String date=request.getParameter("date");
		System.out.println(request.getParameter("date"));
		String a=userservice.listprojectname(date);
		
		out.print(a);
		
		return null;
	}
	
}
