
package com;

import java.util.List;

public class UserService {
	private UserDAO userdao;
	
	public void saveUser(UserBean user){
		getUserdao().saveUser(user);
	}
	
	public void updateUser(UserBean user){
		getUserdao().updateUser(user);
	}
	
	public void DeleteUser(UserBean user){
		getUserdao().deleteUser(user);
	}
	
	public String listprojectname(String date){
		String a=getUserdao().listNames(date);
		return a;
	}
	
	public UserBean projectdetail(String name){
		UserBean a=getUserdao().details(name);
		return a;
	}
	/**
	 * @return Returns the userdao.
	 */
	public UserDAO getUserdao() {
		return userdao;
	}
	/**
	 * @param userdao The userdao to set.
	 */
	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
}
