package com.khan.org.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.khan.org.mapper.EmployeeRowMapper;
import com.khan.org.model.Employee;

public class EmployeeDaoImpl {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void createEmployee(Employee employee) {
		String SQL = "INSERT INTO employee_table(employeeName ,email,gender,salary) VALUES (?,?,?,?)";
		int update = getJdbcTemplate().update(SQL,employee.getEmployeeName(),
				employee.getEmail(), employee.getGender(), employee.getSalary());
		if (update == 1) {
			System.out.println("Employee is created..");
		}
	}

	public Employee fetchEmployeeById(Integer employeeId) {
		String SQL = "SELECT * FROM employee_table WHERE employeeId = ?";
		return getJdbcTemplate().queryForObject(SQL, new EmployeeRowMapper(), employeeId);
	}

	public List<Employee> fetchAllEmployees() {
		String SQL = "SELECT * FROM employee_table";
		return getJdbcTemplate().query(SQL, new EmployeeRowMapper());
	}

	public void updateEmployeeEmailById(String newEmail, Integer employeeId) {
		String SQL = "UPDATE employee_table set email = ? WHERE employeeId = ?";
		int update = getJdbcTemplate().update(SQL, newEmail, employeeId);
		if (update == 1) {
			System.out.println("Employee email is updated for ID = " + employeeId);
		}
	}

	public void deleteEmployeeById(Integer employeeId) {
		String SQL = "DELETE FROM employee_table WHERE employeeId = ?";
		int update = getJdbcTemplate().update(SQL, employeeId);
		if (update == 1) {
			System.out.println("Employee is deleted with ID = " + employeeId);
		}
	}
}
