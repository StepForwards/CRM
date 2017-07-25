package com.forward.dao.impl;



import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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
		u.setU_updatetime(new Timestamp(System.currentTimeMillis()));
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
		department.setD_updatetime(new Timestamp(System.currentTimeMillis()));
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
		role.setR_updatetime(new Timestamp(System.currentTimeMillis()));
		try {
			qr.update(sql,role.getR_name(),role.getR_desc(),role.getR_updatetime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Department> selectAllDepartment() {
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
	public List<Role> selectAllRole() {
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
	public List<User> selectAllUser() {
		List<User> list = null;
		sql = "select * from t_user";
		try {
		list = qr.query(sql, new BeanListHandler<>(User.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<User> selectUser(String u_key,String t_key) {
		List<User> list = null;
		switch(u_key){
			case "u_name": sql = "select * from t_user where u_name like '%' ? '%' ";break;
			case "u_department": sql = "select * from t_user where u_department = (select d_id from t_department where d_name like '%' ? '%') ";break;
			case "u_role": sql = "select * from t_user where u_role like select r_id from t_role where r_name = '%' ? '%' ";break;		
		}
		try {
		list = qr.query(sql, new BeanListHandler<>(User.class),t_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Object selectKindInfo(String kind,int id) {
		try {
			switch (kind) {
			case "department": 
				sql = "select * from t_department where d_id = ?";
				Department department = qr.query(sql, new BeanHandler<>(Department.class),id);return department;
			case "role": 
				sql = "select * from t_role where r_id = ?";
				Role role = qr.query(sql, new BeanHandler<>(Role.class),id);return role;
			case "user": 
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateKindInfo(String kind,Object object) {
		
		try {
			switch (kind) {
			case "department":
				sql = "update t_department set d_name = ?, d_desc = ?, d_updatetime = ? where d_id = ?";
				Department department = (Department)object;
				department.setD_updatetime(new Timestamp(System.currentTimeMillis()));
				qr.update(sql,department.getD_name(),department.getD_desc(),department.getD_updatetime(),department.getD_id());				
				break;
			case "role":
				sql = "update t_role set d_name = ?, d_desc = ?, d_updatetime = ? where d_id = ?";
				Role role = (Role)object;
				role.setR_updatetime(new Timestamp(System.currentTimeMillis()));
				qr.update(sql,role.getR_name(),role.getR_desc(),role.getR_updatetime(),role.getR_id());				
				break;
			case "user":
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteKindInfo(String kind,int id) {
		switch(kind){
		case "department": sql = "delete from t_department where d_id = ?";break;
		case "role": sql = "delete from t_role where r_id = ?";break;
		case "user": sql = "delete from t_user where u_id = ?";break;		
		}
		try {
		 qr.update(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int selectUserCount() {
		int num = 0;
		sql = "select count(*) from t_user";
		try {
		num = qr.query(sql, new ScalarHandler<Long>()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<User> selectUserLimit(int currentPage, int size) {
		List<User> list = null;
		sql = "select * from t_user limit ?,?";
		try {
		list = qr.query(sql, new BeanListHandler<>(User.class),(currentPage-1)*size,size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
