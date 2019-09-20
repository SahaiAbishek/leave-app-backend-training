package com.training.leave.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.training.leave.app.entity.EmployeeEntity;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Long> {

	public List<EmployeeEntity> findByEmpManagerId(Integer empManagerId);

}
