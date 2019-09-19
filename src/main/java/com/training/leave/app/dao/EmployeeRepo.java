package com.training.leave.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.leave.app.entity.EmployeeEntity;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Long>{

}
