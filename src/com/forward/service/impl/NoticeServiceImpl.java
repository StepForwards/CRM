package com.forward.service.impl;

import java.util.List;

import com.forward.dao.NoticeDao;
import com.forward.dao.impl.NoticeDaoImpl;
import com.forward.model.Notice;
import com.forward.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	private NoticeDao nd = new NoticeDaoImpl();
	@Override
	public List<Notice> selectNoticeByDepartmentId(int u_departmentid,String noticeSearchField,String noticeKeyWord,int currentPage,int pageSize) {
		
		return nd.selectNoticeByDepartmentId(u_departmentid,noticeSearchField,noticeKeyWord,currentPage,pageSize);
	}
	@Override
	public int selectNoticeCountByKey(int u_departmentid,String noticeKeyWord, String noticeSearchField) {
		
		return nd.selectNoticeCountByKsy(u_departmentid,noticeKeyWord,noticeSearchField);
	}
	@Override
	public void addNotice(Notice notice) {
		
		nd.addNotice(notice);
	}
	@Override
	public void deleteNoticeById(String n_id) {
		
		nd.deleteNoticeById(n_id);
	}
	@Override
	public Notice selectNoticeById(String id) {
		
		return nd.selectNOticeById(id);
	}
	@Override
	public void updateNoticeById(Notice notice) {
		
		nd.updateNoticeById(notice);
	}

}
