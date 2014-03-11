package com.scusw.teacher.service.impl;

import java.util.List;

import com.scusw.model.StaffInfo;
import com.scusw.model.TeacherInfo;
import com.scusw.teacher.dao.TeacherDao;
import com.scusw.teacher.service.TeacherService;


public class TeacherServiceImpl implements TeacherService{

	private TeacherDao teacherDao;
	

	
	public TeacherDao getTeacherDao() {
		return teacherDao;
	}



	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	
	public TeacherInfo getOwnTeacherInfo(int staffId){
		return teacherDao.queryByTeacehrId(staffId);
	}

}
