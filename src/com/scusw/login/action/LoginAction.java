
package com.scusw.login.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.scusw.login.service.LoginService;
import com.scusw.model.StaffInfo;
import com.scusw.model.StudentInfo;
import com.scusw.util.MD5Util;
public class LoginAction {
	private StudentInfo studentInfo;
	private StaffInfo staffInfo;
	private LoginService loginService;
	private String loginNo;
	private String loginPass;
	private String role;
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	public static Logger logger = Logger.getLogger(LoginAction.class);
	
	public String getLoginNo() {
		return loginNo;
	}
	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}
	
	public StaffInfo getStaffInfo() {
		return staffInfo;
	}
	public void setStaffInfo(StaffInfo staffInfo) {
		this.staffInfo = staffInfo;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public String checkUser() {
		
		session = ActionContext.getContext().getSession();
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		if ("student".equals(role)) {
			return checkStuLogin();
		} else if ("staff".equals(role)) {
			return checkStaffLogin();
		}
		return "error";
	}
	public String checkStuLogin() {
		studentInfo = new StudentInfo();
		studentInfo.setStudentNo(loginNo);
		String passwordInCode = MD5Util.MD5(loginPass);
		studentInfo.setStudentPass(passwordInCode);
		logger.info("获得学生加密密码:"+studentInfo.getStudentPass());
		if (loginService.checkStuLogin(studentInfo)) {
			session.put("role", "student");
			session.put("studentNo", studentInfo.getStudentNo());
			session.put("studentID", studentInfo.getStudentId());
			session.put("studentName", studentInfo.getStudentName());
			logger.info("学生登录成功:"+studentInfo.getStudentNo());
			return "student_success";
		}
		logger.info("学生登录失败:"+studentInfo.getStudentNo());
		request.put("loginstate", "false");
		return "error";
	}
	public String checkStaffLogin() {
		staffInfo = new StaffInfo();
		staffInfo.setStaffNo(loginNo);
		String passwordInCode = MD5Util.MD5(loginPass);
		staffInfo.setStaffPass(passwordInCode);
		logger.info("获得员工加密密码:"+staffInfo.getStaffPass());
		logger.info("获得员工帐号:"+staffInfo.getStaffNo());
		Object obj = loginService.checkStaLogin(staffInfo);
		if (obj != null) {
			staffInfo = (StaffInfo) obj;
			session.put("privilege", loginService.checkPrivilege(staffInfo.getGroupInfo().getGroupId()));//用户权限list
			int type = loginService.checkIfTeacher(staffInfo.getStaffId());
			if (type>=0) {
				session.put("role", "teacher");//教师角色
				session.put("type", type);//教师类型
				session.put("staffId", staffInfo.getStaffId());//员工编号
				session.put("staffName", staffInfo.getStaffName());//员工姓名
				logger.info("教师登录成功:"+staffInfo.getStaffId() + " " + staffInfo.getStaffName());//
				return "teacher_success";
			} else {
				
				session.put("role", "staff");//
				session.put("staffId", staffInfo.getStaffId());//员工编号
				session.put("staffName", staffInfo.getStaffName());//员工姓名
				logger.info("员工登录成功:"+staffInfo.getStaffId() + " " + staffInfo.getStaffName());
				logger.info("登录员工部门："+staffInfo.getPositionInfo().getDepartmentInfo().getDepartmentName());
				return "staff_success";
			}
			
		}
		logger.info("员工登录失败:"+loginNo);
		request.put("loginstate", "false");
		return "error";
	}
	public String loginOut() {
		session = ActionContext.getContext().getSession();
		session.clear();
		return "error"; 
	}
}

