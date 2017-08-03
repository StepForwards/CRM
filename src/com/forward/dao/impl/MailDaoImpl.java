package com.forward.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.forward.dao.MailDao;
import com.forward.model.Mail;
import com.forward.tools.DBUtils;

public class MailDaoImpl implements MailDao {

	@Override
	public void addMail(Mail mail) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "insert into t_mail values(null,?,?,?,?,?,?,?)";
		try {
			qr.update(sql, mail.getM_sendid(),mail.getM_receiveid(),mail.getM_theme(),mail.getM_content(),new Timestamp(System.currentTimeMillis()),mail.getM_sendstatus(),mail.getM_receivestatus());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Mail> selectSendMailByKey(int u_id, String mailKeyWord, String mailSearchField,String m_sendstatus,int currentPage) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		List<Mail> sendMailList = null;
		String sql = "SELECT "
				+ "m.*, u_name "
				+ "FROM "
				+ "t_mail m "
				+ "LEFT JOIN t_user ON m_receiveid = u_id "
				+ "WHERE "
				+ mailSearchField+ " LIKE '%' ? '%' "
				+ "AND m_sendid = ? "
				+ "AND m_sendstatus = ? "
				+ "Limit ?,15";
		try {
			sendMailList = qr.query(sql, new BeanListHandler<>(Mail.class),mailKeyWord,u_id,m_sendstatus,(currentPage-1)*15);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sendMailList;
	}

	@Override
	public int selectSendMailCount(int u_id, String mailKeyWord, String mailSearchField,String m_sendstatus) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		int count = 0;
		String sql = "SELECT "
				+ "count(*) "
				+ "FROM "
				+ "t_mail m "
				+ "LEFT JOIN t_user ON m_receiveid = u_id "
				+ "WHERE "
				+ mailSearchField+ " LIKE '%' ? '%' "
				+ "AND m_sendid = ? "
				+ "AND m_sendstatus = ? ";
		try {
			count = qr.query(sql,new ScalarHandler<Long>(),mailKeyWord,u_id,m_sendstatus).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void deleteSendMail(String status,String m_sendstatus,String m_id) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "UPDATE t_mail SET "+status+" = ? WHERE m_id = ?";
		try {
			qr.update(sql,m_sendstatus,m_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Mail selectMailById(String m_id) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		Mail mail = null;
		String sql = "SELECT "
				+ "m.*, a.u_name r_name,b.u_name s_name "
				+ "FROM "
				+ "t_mail m "
				+ "LEFT JOIN t_user a ON m_receiveid = a.u_id  "
				+ "LEFT JOIN t_user b ON m_sendid = b.u_id   "
				+ "WHERE "
				+ "m_id = ?";
		try {
			mail = qr.query(sql, new BeanHandler<>(Mail.class), m_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mail;
	}

	@Override
	public void sendDraftsMail(Mail mail) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "UPDATE t_mail "
				+ "SET m_sendid = ?, m_receiveid = ?, m_theme = ?, m_content = ?, m_sendtime = ?, m_sendstatus = ?, m_receivestatus = ? "
				+ "WHERE "
				+ "m_id = ?";
		try {
			qr.update(sql, mail.getM_sendid(),mail.getM_receiveid(),mail.getM_theme(),mail.getM_content(),new Timestamp(System.currentTimeMillis()),mail.getM_sendstatus(),mail.getM_receivestatus(),mail.getM_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Mail> selectReceiveMailByKey(int u_id, String mailKeyWord, String mailSearchField,
			String m_receivestatus,int currentPage) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		List<Mail> receiveMailList = null;
		String sql = "SELECT "
				+ "m.*,a.u_name r_name,b.u_name s_name "
				+ "FROM "
				+ "t_mail m "
				+ "LEFT JOIN t_user a ON m_receiveid = a.u_id "
				+ "LEFT JOIN t_user b ON m_sendid = b.u_id "
				+ "WHERE "
				+ mailSearchField+ " LIKE '%' ? '%' "
				+ "AND m_receiveid = ? "
				+ "AND m_receivestatus = ? "
				+ "Limit ?,15";
		try {
			receiveMailList = qr.query(sql, new BeanListHandler<>(Mail.class),mailKeyWord,u_id,m_receivestatus,(currentPage-1)*15);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return receiveMailList;
	}

	@Override
	public int selectReceiveMailCount(int u_id, String mailKeyWord, String mailSearchField, String m_receivestatus) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		int count = 0;
		String sql = "SELECT "
				+ "count(*) "
				+ "FROM "
				+ "t_mail m "
				+ "LEFT JOIN t_user ON m_receiveid = u_id "
				+ "WHERE "
				+ mailSearchField+ " LIKE '%' ? '%' "
				+ "AND m_receiveid = ? "
				+ "AND m_receivestatus = ? ";
		try {
			count = qr.query(sql,new ScalarHandler<Long>(),mailKeyWord,u_id,m_receivestatus).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void deleteInboxMail(String m_receivestatus, String m_id) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		String sql = "UPDATE t_mail SET m_receivestatus = ? WHERE m_id = ?";
		try {
			qr.update(sql,m_receivestatus,m_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int selectDustbinMailCount(int u_id, String mailKeyWord, String mailSearchField) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		int count = 0;
		String sql = "SELECT "
				+ "count(*) "
				+ "FROM "
				+ "t_mail m "
				+ "LEFT JOIN t_user ON m_receiveid = u_id "
				+ "WHERE "
				+ mailSearchField +" LIKE '%' ? '%'  "
				+ "AND m_sendid = ? "
				+ "AND m_sendstatus = 3	"
				+ "OR "
				+ "( "
				+ mailSearchField +" LIKE '%' ? '%'  "
				+ " AND	m_receiveid = ? "
				+ "	AND m_receivestatus = 3 "
				+ ") ";
		try {
			count = qr.query(sql, new ScalarHandler<Long>(),mailKeyWord,u_id,mailKeyWord,u_id).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return count;
	}

	@Override
	public List<Mail> selectDustbinMailByKey(int u_id, String mailKeyWord, String mailSearchField,
			String m_sendstatus,int currentPage) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		List<Mail> mailList = null;
		String sql = "SELECT "
				+ "m.*, u_name "
				+ "FROM "
				+ "t_mail m "
				+ "LEFT JOIN t_user ON m_receiveid = u_id "
				+ "WHERE "
				+ mailSearchField +" LIKE '%' ? '%'  "
				+ "AND m_sendid = ? "
				+ "AND m_sendstatus = 3 "
				+ "OR  "
				+ "( "
				+ mailSearchField +" LIKE '%' ? '%'  "
				+ " AND	m_receiveid = ? "
				+ " AND m_receivestatus = 3 "
				+ ") "
				+ "LIMIT ?, "
				+ "15 ";
		try {
			mailList = qr.query(sql,new BeanListHandler<>(Mail.class) ,mailKeyWord,u_id,mailKeyWord,u_id,(currentPage-1)*15);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return mailList;
	}

	@Override
	public Mail selectInboxMailById(String m_id) {
		QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
		Mail mail = null;
		String sql = "SELECT "
				+ "m.*, u_name "
				+ "FROM "
				+ "t_mail m "
				+ "LEFT JOIN t_user ON m_sendid = u_id "
				+ "WHERE "
				+ "m_id = ? ";
		try {
			mail = qr.query(sql, new BeanHandler<>(Mail.class), m_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mail;
	}

	

}
