package com.training.leave.app.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.leave.app.dao.EmployeeRepo;
import com.training.leave.app.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	public Employee getEmployeeDetails(long id) throws Exception {
		Employee target = new Employee();
		Optional<com.training.leave.app.entity.Employee> optional = empRepo.findById(id);
		if (null != optional) {
			BeanUtils.copyProperties(optional.get(), target);
			return target;
		} else {
			throw new Exception("No employees found with the specified ID : " + id);
		}

	}

}
