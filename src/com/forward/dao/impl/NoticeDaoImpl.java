package com.forward.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.forward.dao.NoticeDao;
import com.forward.model.Notice;
import com.forward.tools.DBUtils;

public class NoticeDaoImpl implements NoticeDao {

	@Override
	public List<Notice> selectNoticeByDepartmentId(int u_departmentid,String noticeSearchField,String noticeKeyWord,int currentPage,int pageSize) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select n.*,u_name,d_name "
				+ "from t_notice n,t_user,t_department "
				+ "where n_userid = u_id "
				+ "and n_departmentid = d_id "
				+ "and d_id = ? "
				+ "and "+noticeSearchField+" like '%' ? '%' "
				+ "or "
				+ "(n_userid = u_id "
				+ "and n_departmentid = 0 "
				+ "and "+noticeSearchField+" like '%' ? '%' "
				+ "and d_id = "
				+ "any (select u_departmentid from t_user where u_id = "
				+ "any (select n_userid from t_notice where n_departmentid = 0) "
				+ ") "
				+ ") limit ?,? ";
		List<Notice> noticeList = null;
		try {
			 noticeList= qr.query(sql, new BeanListHandler<>(Notice.class),u_departmentid,noticeKeyWord,noticeKeyWord,(currentPage-1)*pageSize,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public int selectNoticeCountByKsy(int u_departmentid,String noticeKeyWord, String noticeSearchField) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select count(*) "
				+ "from t_notice n,t_user,t_department "
				+ "where n_userid = u_id "
				+ "and n_departmentid = d_id "
				+ "and d_id = ? "
				+ "and "+noticeSearchField+" like '%' ? '%' "
				+ "or "
				+ "(n_userid = u_id "
				+ "and n_departmentid = 0 "
				+ "and "+noticeSearchField+" like '%' ? '%' "
				+ "and d_id = "
				+ "any (select u_departmentid from t_user where u_id = "
				+ "any (select n_userid from t_notice where n_departmentid = 0) "
				+ ") "
				+ ") ";
		int count = 0;
		try {
			count = qr.query(sql, new ScalarHandler<Long>(),u_departmentid,noticeKeyWord,noticeKeyWord).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void addNotice(Notice notice) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "insert into t_notice values(null,?,?,?,?,?,?)";
		try {
			qr.update(sql, notice.getN_userid(),notice.getN_theme(),notice.getN_departmentid(),notice.getN_content(),notice.getN_begintime(),notice.getN_endtime());
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteNoticeById(String n_id) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "delete from t_notice where n_id = ?";
		try {
			qr.update(sql, n_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Notice selectNOticeById(String id) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from t_notice where n_id = ?";
		Notice notice = null;
		try {
			notice = qr.query(sql, new BeanHandler<>(Notice.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}

	@Override
	public void updateNoticeById(Notice notice) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "update t_notice set n_userid = ?, n_theme = ?, n_departmentid = ?, n_content = ?, n_begintime = ? ,n_endtime = ? where n_id = ?";
		try {
			qr.update(sql, notice.getN_userid(),notice.getN_theme(),notice.getN_departmentid(),notice.getN_content(),notice.getN_begintime(),notice.getN_endtime(),notice.getN_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
