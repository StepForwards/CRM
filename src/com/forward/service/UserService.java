package com.forward.service;

import java.util.List;

import com.forward.model.Department;
import com.forward.model.Role;
import com.forward.model.User;

public interface UserService {
	
	User login(User user);
	String addUser(User user);
	String addDepartment(Department department);
	String updateKindInfo(String kind,Object object);
	String deleteKindInfo(String kind,int id);
	String addRole(Role role);
	List<Department> selectAllDepartment();
	Object selectKindInfo(String kind,int id);
	List<Role> selectAllRole();
	List<User> selectAllUser();
	List<User> selectUser(String u_key,String t_key);
	int selectUserCount();
	List<User> selectUserLimit(int currentPage, int size);
}
