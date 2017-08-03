package com.forward.service;

import java.util.List;

import com.forward.model.Mail;

public interface MailService {

	void addMail(Mail mail);

	List<Mail> selectSendMailByKey(int u_id, String mailKeyWord, String mailSearchField,String m_sendstatus, int currentPage);

	int selectSendMailCount(int u_id, String mailKeyWord, String mailSearchField,String m_sendstatus);

	void deleteSendMail(String status,String m_sendstatus,String m_id);

	Mail selectMailById(String m_id);

	void sendDraftsMail(Mail mail);

	List<Mail> selectReceiveMailByKey(int u_id, String mailKeyWord, String mailSearchField, String m_receivestatus,int currentPage);

	int selectReceiveMailCount(int u_id, String mailKeyWord, String mailSearchField, String m_receivestatus);

	void deleteInboxMail(String m_receivestatus, String m_id);

	int selectDustbinMailCount(int u_id, String mailKeyWord, String mailSearchField);

	List<Mail> selectDustbinMailByKey(int u_id, String mailKeyWord, String mailSearchField, String m_sendstatus, int currentPage);

	Mail selectInboxMailById(String m_id);

}
