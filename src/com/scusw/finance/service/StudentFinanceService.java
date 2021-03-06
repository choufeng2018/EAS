/**
 * 
 */
package com.scusw.finance.service;

import java.util.List;

import com.scusw.model.StudentFees;
import com.scusw.model.StudentInfo;

/**
 * @author 杨昭远
 *
 */
public interface StudentFinanceService {
	/**
	 * 
	 * 方法描述
	 * param args0 参数0
	 * return
	 */
	public List<StudentInfo> searchAll();
	/**
	 * 
	 * 方法描述
	 * param args0 参数0
	 * return
	 */
	public List<StudentInfo> conditionSearch(StudentInfo studentInfo);
	/**
	 * 方法描述
	 * param args0 参数0
	 * return
	 */
	public StudentInfo findById(StudentInfo studentInfo);
	/**
	 * 方法描述
	 * param args0 参数0
	 * return
	 */
	public void updateBalance(StudentFees studentFees);
	/**
	 * 方法描述
	 * param args0 参数0
	 * return
	 */
	public void addStudentFees(StudentFees studentFees);
	/**
	 * 方法描述
	 * param args0 参数0
	 * return
	 */
	public StudentInfo findById(StudentFees studentFees);
	/**
	 * 方法描述
	 * param args0 参数0
	 * return
	 */
	public void updateStudentFees(StudentFees studentFees);

}
