package com.forward.service;

import java.util.List;

import com.forward.model.Department;
import com.forward.model.Role;
import com.forward.model.User;

public interface UserService {
	
	User login(User user);
	String addUser(User user);
	String addDepartment(Department department);
	String addRole(Role role);
	List<Department> selectDepartment();
	List<Role> selectRole();
	List<User> selectUser();
	List<User> selectUser(String t_key);
}
