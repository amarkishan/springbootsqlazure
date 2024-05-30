package com.cg.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.demo.dao.EmployeeDaoI;
import com.cg.demo.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{
	
	@Autowired
	private EmployeeDaoI dao;
	
	public Employee CreateEmployee(Employee emp) {
		return dao.CreateEmployee(emp);
	}
	
	public Employee findEmployeeById(long empId) {
		return dao.findEmployeeById(empId);
	}
	public Employee updateEmployee(Employee emp) {
		return dao.updateEmployee(emp);
	}
	public List<Employee> findAllEmployees(){
		 return dao.findAllEmployees();
	}
	public void deleteEmployee(long empId) {
		 dao.deleteEmployee(empId);
	}
}
