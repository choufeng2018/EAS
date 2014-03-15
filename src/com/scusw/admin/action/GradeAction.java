package com.scusw.admin.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.scusw.admin.service.GradeService;
import com.scusw.model.GradeInfo;

public class GradeAction {
	Logger logger = Logger.getLogger(GradeAction.class);
	private GradeService gradeService;
	private Map<String,Object> request;
	private int gradeId;
	
	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public GradeService getGradeService() {
		return gradeService;
	}

	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}
	
	public String queryGrade() {
		List<GradeInfo> list = gradeService.queryGrade();
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("grade", list);
		logger.info("queryGrade");
		return "success";
	}
	public String deleteGrade() {
		gradeService.deleteGrade(gradeId, false);
		return this.queryGrade();
	}
	
}