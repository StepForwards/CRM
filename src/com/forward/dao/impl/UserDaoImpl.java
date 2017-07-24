package com.forward.dao.impl;



import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.forward.dao.UserDao;
import com.forward.model.Department;
import com.forward.model.Role;
import com.forward.model.User;
import com.forward.tools.DBUtils;

public class UserDaoImpl implements UserDao {
	private User user;
	private String sql;
	private QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
	
	@Override
	public User login(User u) {
		
		sql = "select u_name,u_pwd from t_user where u_name = ? and u_pwd = ?";
		try {
			user = qr.query(sql, new BeanHandler<>(User.class),u.getU_name(),u.getU_pwd());
			System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String addUser(User u) {
		sql = "insert into t_user values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql, u.getU_name(),u.getU_pwd(),u.getU_departmentid(),u.getU_roleid(),u.getU_sex(),u.getU_phone(),u.getU_address(),u.getU_age(),u.getU_telphone(),u.getU_idcard(),u.getU_mail(),u.getU_qq(),u.getU_hobby(),u.getU_edu(),u.getU_salarycard(),u.getU_nation(),u.getU_marry(),u.getU_remark(),u.getU_updatetime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addDepartment(Department department) {
		sql = "insert into t_department values(null,?,?,?)";
		try {
			qr.update(sql,department.getD_name(),department.getD_desc(),department.getD_updatetime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addRole(Role role) {
		sql = "insert into t_role values(null,?,?,?)";
		try {
			qr.update(sql,role.getR_name(),role.getR_desc(),role.getR_updatetime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Department> selectDepartment() {
		List<Department> list = null;
		sql = "select * from t_department";
		try {
		list = qr.query(sql, new BeanListHandler<>(Department.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Role> selectRole() {
		List<Role> list = null;
		sql = "select * from t_role";
		try {
		list = qr.query(sql, new BeanListHandler<>(Role.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<User> selectUser() {
		List<User> list = null;
		sql = "select * from t_user";
		try {
		list = qr.query(sql, new BeanListHandler<>(User.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
