package com.khan.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.org.dao.EmployeeDaoImpl;
import com.khan.org.model.Employee;

@Service
public class EmployeeServiceImpl {

	private EmployeeDaoImpl employeeDao;

	public EmployeeDaoImpl getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void createEmployee(Employee employee) {
		getEmployeeDao().createEmployee(employee);
	}

	public Employee getEmployeeById(Integer employeeId) {
		return getEmployeeDao().fetchEmployeeById(employeeId);
	}

	public List<Employee> getAllEmployees() {
		return getEmployeeDao().fetchAllEmployees();
	}

	public void updateEmployeeEmailById(String newEmail, Integer employeeId) {
		getEmployeeDao().updateEmployeeEmailById(newEmail, employeeId);
	}

	public void deleteEmployeeById(Integer employeeId) {
		getEmployeeDao().deleteEmployeeById(employeeId);

	}
}
