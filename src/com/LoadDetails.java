package com;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoadDetails extends Action {

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		
		UserService userservice = (UserService) ServiceFinder.getContext(request).getBean("userservice");
		String name=request.getParameter("name");
		System.out.println(request.getParameter("name"));
		UserBean a=userservice.projectdetail(name);
		/*HashMap<String, String> map=new HashMap<String, String>();
		
		String aa= Integer.toString(a.getPrjectid());
		map.put("month", a.getMonth());
		map.put("Projectname", );
		map.put("pid", aa);
		map.put("created", a.getCreated());
		map.put("Projectdetail", a.getProjectdetail());
		map.put("Stratdate", a.getStratdate());
		map.put("Enddate", a.getEnddate());
		map.put("Status", a.getStatus());
		a.getProjectname()*/
		out.print(a.getMonth()+",");
		out.print(a.getProjectname()+",");
		out.print(a.getUserId()+",");
		out.print(a.getProjectdetail()+",");
		out.print(a.getCreated()+",");
		out.print(a.getStratdate()+",");
		out.print(a.getEnddate()+",");
		out.print(a.getStatus());
	
	
		
		
	//	out.print(map);
		
		return null;
	}
	
}
