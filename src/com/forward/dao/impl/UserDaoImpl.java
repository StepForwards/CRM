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
	
	@Override
	public User login(User u) {
		
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
		sql = "select u_name,u_pwd from t_user where u_name = ? and u_pwd = ?";
		try {
			user = qr.query(sql, new BeanHandler<>(User.class),u.getU_name(),u.getU_pwd());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String addUser(User u) {
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
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
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
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
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
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
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
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
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
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
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
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
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
		List<User> list = null;
		switch(u_key){
			case "u_name": sql = "select * from t_user,t_role,t_department where u_name like '%' ? '%' and u_departmentid = d_id and u_roleid = r_id limit ?,?";break;
			case "u_department": sql = "select * from t_user where u_departmentid = (select d_id from t_department where d_name like '%' ? '%') ";break;
			case "u_role": sql = "select * from t_user where u_roleid = (select r_id from t_role where r_name like '%' ? '%') ";break;		
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
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
		try {
			switch (kind) {
			case "department": 
				sql = "select * from t_department where d_id = ?";
				Department department = qr.query(sql, new BeanHandler<>(Department.class),id);return department;
			case "role": 
				sql = "select * from t_role where r_id = ?";
				Role role = qr.query(sql, new BeanHandler<>(Role.class),id);return role;
			case "user": 
				sql = "select * from t_user where u_id = ?";
				User user = qr.query(sql, new BeanHandler<>(User.class),id);return user;
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateKindInfo(String kind,Object object) {
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
		try {
			switch (kind) {
			case "department":
				sql = "update t_department set d_name = ?, d_desc = ?, d_updatetime = ? where d_id = ?";
				Department department = (Department)object;
				department.setD_updatetime(new Timestamp(System.currentTimeMillis()));
				qr.update(sql,department.getD_name(),department.getD_desc(),department.getD_updatetime(),department.getD_id());				
				break;
			case "role":
				sql = "update t_role set r_name = ?, r_desc = ?, r_updatetime = ? where r_id = ?";
				Role role = (Role)object;
				role.setR_updatetime(new Timestamp(System.currentTimeMillis()));
				qr.update(sql,role.getR_name(),role.getR_desc(),role.getR_updatetime(),role.getR_id());
				break;
			case "user":
				sql = "update t_user set u_name = ?,u_pwd = ?,u_departmentid = ?,u_roleid = ?,u_sex = ?,u_phone = ?,u_address = ?,u_age = ?,u_telphone = ?,u_idcard = ?,u_mail = ?,u_qq = ?,u_hobby = ?,u_edu = ?,u_salarycard = ?,u_nation = ?,u_marry = ?,u_remark = ?,u_updatetime = ? where u_id = ?";
				User user = (User)object;
				user.setU_updatetime(new Timestamp(System.currentTimeMillis()));
				qr.update(sql, user.getU_name(),user.getU_pwd(),user.getU_departmentid(),user.getU_roleid(),user.getU_sex(),user.getU_phone(),user.getU_address(),user.getU_age(),user.getU_telphone(),user.getU_idcard(),user.getU_mail(),user.getU_qq(),user.getU_hobby(),user.getU_edu(),user.getU_salarycard(),user.getU_nation(),user.getU_marry(),user.getU_remark(),user.getU_updatetime(),user.getU_id());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteKindInfo(String kind,int id) {
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
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
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
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
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());   
		List<User> list = null;
		sql = "select * from t_user,t_role,t_department where u_departmentid = d_id and u_roleid = r_id limit ?,?";
		try {
		list = qr.query(sql, new BeanListHandler<>(User.class),(currentPage-1)*size,size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int selectUserCountByKey(String u_key, String t_key) {
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());
		int num = 0;
		sql = "select count(*) from t_user,t_role,t_department where "+u_key+" like '%' ? '%' and u_departmentid = d_id and u_roleid = r_id";
		try {
		num = qr.query(sql, new ScalarHandler<Long>(),t_key).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<User> selectUserLimitByKey(int currentPage, int size, String u_key, String t_key) {
		QueryRunner qr  = new QueryRunner(DBUtils.getDataSource());   
		sql = "select * from t_user,t_role,t_department where "+u_key+" like '%' ? '%' and u_departmentid = d_id and u_roleid = r_id limit ?,?";
		List<User> list = null;
		try {
		list = qr.query(sql, new BeanListHandler<>(User.class),t_key,(currentPage-1)*size,size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
