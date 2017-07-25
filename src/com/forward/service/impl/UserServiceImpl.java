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
	public List<Department> selectAllDepartment() {
		return ud.selectAllDepartment();
	}
	@Override
	public List<Role> selectAllRole() {
		return ud.selectAllRole();
	}
	@Override
	public List<User> selectAllUser() {
		return ud.selectAllUser();
	}
	@Override
	public List<User> selectUser(String u_key,String t_key) {
		return ud.selectUser(u_key,t_key);
	}
	@Override
	public Object selectKindInfo(String kind,int id) {
		return ud.selectKindInfo(kind,id);
	}
	@Override
	public String updateKindInfo(String kind, Object object) {
		return ud.updateKindInfo(kind,object);
		
	}
	@Override
	public String deleteKindInfo(String kind,int id) {
		return ud.deleteKindInfo(kind,id);
	}
	@Override
	public int selectUserCount() {
		return ud.selectUserCount();
	}
	@Override
	public List<User> selectUserLimit(int currentPage, int size) {
		return ud.selectUserLimit(currentPage,size);
	}

}
