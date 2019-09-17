package com.training.leave.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.leave.app.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Long>{

}
