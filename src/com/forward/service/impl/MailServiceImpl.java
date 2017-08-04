package com.forward.service.impl;

import java.util.List;

import com.forward.dao.MailDao;
import com.forward.dao.impl.MailDaoImpl;
import com.forward.model.Mail;

public class MailServiceImpl implements com.forward.service.MailService {
	private MailDao md = new MailDaoImpl();
	
	@Override
	public void addMail(Mail mail) {
		
		md.addMail(mail);
	}

	@Override
	public List<Mail> selectSendMailByKey(int u_id, String mailKeyWord, String mailSearchField,String m_sendstatus,int currentPage) {
		
		return md.selectSendMailByKey(u_id,mailKeyWord,mailSearchField,m_sendstatus,currentPage);
	}

	@Override
	public int selectSendMailCount(int u_id, String mailKeyWord, String mailSearchField,String m_sendstatus) {
		
		return md.selectSendMailCount(u_id,mailKeyWord,mailSearchField,m_sendstatus);
	}

	@Override
	public void deleteSendMail(String status,String m_sendstatus,String m_id) {
		
		md.deleteSendMail(status, m_sendstatus, m_id);
	}

	@Override
	public Mail selectMailById(String m_id) {
		
		return md.selectMailById(m_id);
	}

	@Override
	public void sendDraftsMail(Mail mail) {
		
		md.sendDraftsMail(mail);
	}

	@Override
	public List<Mail> selectReceiveMailByKey(int u_id, String mailKeyWord, String mailSearchField,
			String m_receivestatus,int currentPage) {
		
		return md.selectReceiveMailByKey(u_id,mailKeyWord,mailSearchField,m_receivestatus,currentPage);
	}

	@Override
	public int selectReceiveMailCount(int u_id, String mailKeyWord, String mailSearchField, String m_receivestatus) {
		
		return md.selectReceiveMailCount(u_id,mailKeyWord,mailSearchField,m_receivestatus);
	}

	@Override
	public void deleteInboxMail(String m_receivestatus, String m_id) {
		
		md.deleteInboxMail(m_receivestatus,m_id);
	}

	@Override
	public int selectDustbinMailCount(int u_id, String mailKeyWord, String mailSearchField) {
		
		return md.selectDustbinMailCount(u_id,mailKeyWord,mailSearchField);
	}

	@Override
	public List<Mail> selectDustbinMailByKey(int u_id, String mailKeyWord, String mailSearchField,
			String m_sendstatus,int currentPage) {
		
		return md.selectDustbinMailByKey(u_id,mailKeyWord,mailSearchField,m_sendstatus,currentPage);
	}

	@Override
	public Mail selectInboxMailById(String m_id) {
		
		return md.selectInboxMailById(m_id);
	}


}
