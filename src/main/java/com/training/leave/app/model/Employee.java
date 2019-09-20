package com.training.leave.app.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private long empId;
	private String empName;
	private BigInteger phone;
	private String empDept;
	private String empEmail;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date empDoj;
	private int leaveBalance;
	private int empManagerId;
	private Set<Leaves> leaves;

	public Set<Leaves> getLeaves() {
		return leaves;
	}

	public void setLeaves(Set<Leaves> leaves) {
		this.leaves = leaves;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public Date getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}

	public int getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	public int getEmpManagerId() {
		return empManagerId;
	}

	public void setEmpManagerId(int empManagerId) {
		this.empManagerId = empManagerId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", phone=" + phone + ", empDept=" + empDept
				+ ", empEmail=" + empEmail + ", empDoj=" + empDoj + ", leaveBalance=" + leaveBalance + ", empManagerId="
				+ empManagerId + ", leaves=" + leaves + "]";
	}

}
