package com.forward.dao;

import java.util.List;

import com.forward.model.Notice;

public interface NoticeDao {

	List<Notice> selectNoticeByDepartmentId(int u_departmentid,String noticeSearchField,String noticeKeyWord,int currentPage,int pageSize);

	int selectNoticeCountByKsy(int u_departmentid,String noticeKeyWord, String noticeSearchField);

	void addNotice(Notice notice);

	void deleteNoticeById(String n_id);

	Notice selectNOticeById(String id);

	void updateNoticeById(Notice notice);

}
