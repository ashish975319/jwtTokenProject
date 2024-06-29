package com.jwt.token.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.token.model.Employee;

@Service
public class EmployeeService {

//	public List<Employee> getAllEmployee();
//	public Employee getEmployeerById(int id);
//	public Employee saveEmployee(Employee employee);
//	public Employee updateEmployee(int id, Employee employee);
//	public void deleteUser(int id);

	private List<Employee> empList = new ArrayList<Employee>();

	public EmployeeService() {
		empList.add(new Employee(UUID.randomUUID().toString(), "ashish", "ashish@gmail.com"));
		empList.add(new Employee(UUID.randomUUID().toString(), "jhon", "jhon@gmail.com"));
		empList.add(new Employee(UUID.randomUUID().toString(), "golu", "golu@gmail.com"));

	}

	public List<Employee> getEmployeesList() {
		return empList;
	}

}
