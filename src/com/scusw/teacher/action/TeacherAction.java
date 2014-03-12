package com.scusw.teacher.action;

import java.util.List;
import java.util.Map;



import com.opensymphony.xwork2.ActionContext;
import com.scusw.model.CourseInfo;
import com.scusw.model.RegisterInfo;
import com.scusw.model.StaffInfo;
import com.scusw.model.StudentInfo;
import com.scusw.model.TeacherInfo;
import com.scusw.teacher.service.TeacherService;

public class TeacherAction {
	private TeacherService teacherService;
	private TeacherInfo teacher;
	private StaffInfo staff;
	private StudentInfo student;
	private CourseInfo course;
	private RegisterInfo register;
	private Map<String,Object> request;
	private Map<String, Object> session;
	
	private String studentName;
	private String studentNo;
	private int courseId;
	private int registerId;
	
	
	public StaffInfo getStaff() {
		return staff;
	}
	public void setStaff(StaffInfo staff) {
		this.staff = staff;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public TeacherInfo getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherInfo teacher) {
		this.teacher = teacher;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudent(StudentInfo student) {
		this.student = student;
	}
	public StudentInfo getStudent() {
		return student;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public void setCourse(CourseInfo course) {
		this.course = course;
	}
	public CourseInfo getCourse() {
		return course;
	}
	public void setRegister(RegisterInfo register) {
		this.register = register;
	}
	public RegisterInfo getRegister() {
		return register;
	}
	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}
	public int getRegisterId() {
		return registerId;
	}
	
	//获取老师个人信息
	public String getOwnTeacherInfo(){
		session = ActionContext.getContext().getSession();
		int staffId = (Integer) session.get("staffID");
		teacher=teacherService.getOwnTeacherInfo(staffId);
		return "getOwnTeacherInfo";
	}
	
	//进入更新页面，更新页面中有老师原本的个人信息提示
	public String updateOwnTeacherInfo1(){
		session = ActionContext.getContext().getSession();
		int staffId = (Integer) session.get("staffID");
		teacher=teacherService.getOwnTeacherInfo(staffId);
		return "updateOwnTeacherInfo1";
	}
	
	//接收需要更新的信息并更新
	public String updateOwnTeacherInfo2(){		
		teacherService.updateTeacher(staff);
		
		session = ActionContext.getContext().getSession();
		int staffId = (Integer) session.get("staffID");
		teacher=teacherService.getOwnTeacherInfo(staffId);
		
		return "updateOwnTeacherInfo2";
	}

	public String searchStudent(){
		request=(Map)ActionContext.getContext().get("request");
		
		if(!studentNo.equals("")){
			List list=teacherService.searchStudentByNo(studentNo);
			request.put("students",list);
		}else if(!studentName.equals("")){
			List list=teacherService.searchStudentByName(studentName);
			request.put("students",list);
		}else{
			List list=teacherService.searchStudentAll();
			request.put("students",list);
		}
		return "searchStudent";
	}
	
	public String getStudentInfo(){
		student=teacherService.getStudentInfo(studentNo);
		return "getStudentInfo";
	}
	
	public String searchTeacherOwnCourse(){
		request=(Map)ActionContext.getContext().get("request");
		
		session = ActionContext.getContext().getSession();
		int staffId = (Integer) session.get("staffID");
		
		List list=teacherService.getTeacherOwnCourse(staffId);
		request.put("courses", list);
		
		return "searchTeacherOwnCourse";
	}

	public String searchOwnStudent(){
		request=(Map)ActionContext.getContext().get("request");
		
		List list=teacherService.searchStudentByCourseId(courseId);
		request.put("students",list);
		
		return "searchOwnStudent";
	}
	
	public String getOwnStudentInfo(){
		student=teacherService.getStudentInfo(studentNo);
		course=teacherService.getCourseById(courseId);
		register=teacherService.getRegisterById(student.getStudentId(),courseId);
		return "getOwnStudentInfo";
	}
	

	
}
