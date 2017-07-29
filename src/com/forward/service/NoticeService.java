package com.forward.service;

import java.util.List;

import com.forward.model.Notice;

public interface NoticeService {

	List<Notice> selectNoticeByDepartmentId(int u_departmentid,String noticeSearchField,String noticeKeyWord,int currentPage,int pageSize);

	int selectNoticeCountByKey(int u_departmentid,String noticeKeyWord, String noticeSearchField);

	void addNotice(Notice notice);

	void deleteNoticeById(String n_id);

	Notice selectNoticeById(String id);

	void updateNoticeById(Notice notice);
	

}
