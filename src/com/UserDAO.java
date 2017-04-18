
package com;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.internal.compiler.apt.model.IElementInfo;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;


public class UserDAO {
	
	private SessionFactory sessionFactory;
	public void saveUser(UserBean user){
		Session session = getSessionFactory().openSession();
		try
		{
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}

	}
	
	public void updateUser(UserBean user){
		Session session = getSessionFactory().openSession();
		try
		{
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(user);
			tx.commit();
			System.out.println("update success");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}

	}
	
	public void deleteUser(UserBean user){
		Session session = getSessionFactory().openSession();
		try
		{
			Transaction tx = session.beginTransaction();
			
			UserBean employee = (UserBean) session.load(UserBean.class, user.userId);
			session.delete(employee);
			tx.commit();
			System.out.println("delete");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}

	}
	
	public String listNames(String user){
		Session session = getSessionFactory().openSession();
		String s=user.substring(0, 7);
		System.out.println(s);
		String a=new String();
		try
		{
			Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(UserBean.class);
			cr.add(Restrictions.ilike("month", s+"%"));
			cr.setProjection(Projections.property("projectname"));
			List results = cr.list();
			
			Iterator r=results.iterator();
			
			while(r.hasNext())
	        {
	            a+=(String) r.next()+",";

	        }
			System.out.println(a);
			//System.out.println(results.size());
			 
			tx.commit();
			return a;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return a;

	}
	
	
	public UserBean details(String user){
		Session session = getSessionFactory().openSession();
		String a=new String();
		 List results=new ArrayList<String>();
		try
		{
			Transaction tx = session.beginTransaction();
			
			  Criteria criteria = session.createCriteria(UserBean.class);
			              criteria.add(Restrictions.eq("projectname", user));
			              UserBean employee = (UserBean) criteria.uniqueResult();
			/*String hql = "from UserBean where projectname is" +user;
	         Query query = session.createQuery(hql);
	        List results = query.list();*/
			
	       /* Criteria criteria = session.createCriteria(UserBean.class);  
	        criteria.add(Restrictions.eq("projectname",user));
	        results = criteria.list();*/
			
			/*Criteria cr = session.createCriteria(UserBean.class);
			cr.add(Restrictions.eq("projectname", user));
			List results = cr.list();
			*/
			/*Iterator r=results.iterator();
			
			while(r.hasNext())
	        {
	           System.out.println(r.next());

	        }
			//System.out.println(a);*/
			             
			              
			tx.commit();
			return employee;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;

	}
	
	

	/**
	 * @return Returns the sessionFactory.
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * @param sessionFactory The sessionFactory to set.
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
