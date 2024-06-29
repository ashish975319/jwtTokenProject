package com.jwt.token.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.token.model.Employee;
import com.jwt.token.repository.EmployeeRepository;
import com.jwt.token.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class HomeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getEmployeesList() {
		log.info("Get employees list");
		return employeeService.getEmployeesList();
	}

	/*
	 * @PostMapping("/save") public ResponseEntity<Employee> saveData(@RequestBody
	 * Employee employee) { Employee saveEmployee =
	 * employeeService.saveEmployee(employee); return
	 * ResponseEntity.status(HttpStatus.CREATED).body(saveEmployee); }
	 * 
	 * @GetMapping("/get") public List<Employee> getData() { List<Employee>
	 * employeeList = employeeService.getEmployeeList(); return employeeList; }
	 */

}
