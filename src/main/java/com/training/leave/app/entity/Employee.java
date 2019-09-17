package com.training.leave.app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	@JsonIgnore
	private long empId;
	@Column(name = "EMP_NAME")
	private String empName;
	@Column(name = "EMP_PHONE")
	private BigInteger phone;
	@Column(name = "EMP_DEPT")
	private String empDept;
	@Column(name = "EMP_MAIL")
	private String empEmail;
	@Column(name = "EMP_DOJ")
	private Date empDoj;
	@Column(name = "LEAVE_BALANCE")
	private int leaveBalance;
	@Column(name = "EMP_MNG_ID")
	private int empManagerId;

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

}
