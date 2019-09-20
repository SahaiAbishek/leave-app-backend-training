package com.training.leave.app.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.leave.app.exception.LeavesExceptionResolver;
import com.training.leave.app.model.Employee;
import com.training.leave.app.model.Leaves;
import com.training.leave.app.service.EmployeeService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@RequestMapping(method = RequestMethod.GET, path = "/employeeId/{id}")
	@CrossOrigin
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Handled Exception", response = LeavesExceptionResolver.class),
			@ApiResponse(code = 500, message = "Handled Exception", response = LeavesExceptionResolver.class),
			@ApiResponse(code = 200, message = "OK", response = Employee.class) })
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable Long id) throws Exception {
		return new ResponseEntity<>(empService.getEmployeeDetails(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/leaves/{empId}")
	@CrossOrigin
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Handled Exception", response = LeavesExceptionResolver.class),
			@ApiResponse(code = 500, message = "Handled Exception", response = LeavesExceptionResolver.class),
			@ApiResponse(code = 200, message = "OK", response = Employee.class, responseContainer = "Set") })
	public ResponseEntity<Set<Leaves>> getLeavesByEmployeeId(@PathVariable Long empId) throws Exception {
		return new ResponseEntity<>(empService.getEmployeeLeavess(empId), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/reportees/{id}")
	@CrossOrigin
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Handled Exception", response = LeavesExceptionResolver.class),
			@ApiResponse(code = 500, message = "Handled Exception", response = LeavesExceptionResolver.class),
			@ApiResponse(code = 200, message = "OK", response = Employee.class, responseContainer = "List") })
	public ResponseEntity<List<Employee>> getReportees(@PathVariable Integer id) throws Exception {
		return new ResponseEntity<>(empService.getReportees(id), HttpStatus.OK);
	}
}
