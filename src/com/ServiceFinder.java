   
 package  com;
   
 
  
 import org.springframework.context.ApplicationContext; 
  
 import org.springframework.web.context.support.WebApplicationContextUtils; 
  

 import javax.servlet.ServletRequest; 
 import javax.servlet.http.HttpServletRequest; 
  
  

 public class ServiceFinder { 



  public static ApplicationContext getContext(HttpServletRequest httpRequest) {
	   return WebApplicationContextUtils.getRequiredWebApplicationContext(
						httpRequest.getSession().getServletContext()); 
	 } 
 } 
