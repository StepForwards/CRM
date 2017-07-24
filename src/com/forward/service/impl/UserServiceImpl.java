package com.forward.service.impl;

import java.util.List;

import com.forward.dao.UserDao;
import com.forward.dao.impl.UserDaoImpl;
import com.forward.model.Department;
import com.forward.model.Role;
import com.forward.model.User;
import com.forward.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();
	@Override
	public User login(User user) {
		return ud.login(user);
	}
	@Override
	public String addUser(User user) {
		return ud.addUser(user);
	}
	@Override
	public String addDepartment(Department department) {
		return ud.addDepartment(department);
	}
	@Override
	public String addRole(Role role) {
		return ud.addRole(role);
	}
	@Override
	public List<Department> selectDepartment() {
		return ud.selectDepartment();
	}
	@Override
	public List<Role> selectRole() {
		return ud.selectRole();
	}
	@Override
	public List<User> selectUser() {
		return ud.selectUser();
	}

}
