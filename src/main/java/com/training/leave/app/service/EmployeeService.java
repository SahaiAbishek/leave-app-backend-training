package com.training.leave.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.leave.app.dao.EmployeeRepo;
import com.training.leave.app.entity.EmployeeEntity;
import com.training.leave.app.entity.LeavesEntity;
import com.training.leave.app.model.Employee;
import com.training.leave.app.model.Leaves;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	public Employee getEmployeeDetails(long id) throws Exception {
		Employee target = new Employee();
		Optional<com.training.leave.app.entity.EmployeeEntity> optional = empRepo.findById(id);
		if (null != optional) {
			BeanUtils.copyProperties(optional.get(), target);

			Set<Leaves> targetLeaves = new HashSet<>();
			EmployeeEntity employeeEntity = optional.get();
			Set<LeavesEntity> leaves = employeeEntity.getLeaves();
			for (LeavesEntity leave : leaves) {
				Leaves targetleave = new Leaves();
				BeanUtils.copyProperties(leave, targetleave);
				targetLeaves.add(targetleave);
			}

			target.setLeaves(targetLeaves);
			return target;
		} else {
			throw new Exception("No employees found with the specified ID : " + id);
		}

	}

	public Set<Leaves> getEmployeeLeavess(long empId) throws Exception {
		Set<Leaves> targetLeaves = new HashSet<>();
		Optional<com.training.leave.app.entity.EmployeeEntity> optional = empRepo.findById(empId);
		if (null != optional) {
			EmployeeEntity employeeEntity = optional.get();
			Set<LeavesEntity> leaves = employeeEntity.getLeaves();
			for (LeavesEntity leave : leaves) {
				Leaves target = new Leaves();
				BeanUtils.copyProperties(leave, target);
				targetLeaves.add(target);
			}

			return targetLeaves;
		} else {
			return new HashSet<>();
		}

	}

	public List<Employee> getReportees(int empId) throws Exception {
		List<Employee> targets = new ArrayList<>();
		List<EmployeeEntity> sources = empRepo.findByEmpManagerId(empId);
		if (null != sources) {
			for (EmployeeEntity source : sources) {
				Employee employee = getEmployeeDetails(source.getEmpId());
				targets.add(employee);
			}
			return targets;
		} else {
			throw new Exception("No employees found with Employeed ID : " + empId);
		}
	}

}
