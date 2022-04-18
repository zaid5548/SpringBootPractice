package com.khan.org.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khan.org.model.Employee;
import com.khan.org.service.EmployeeService;
import com.khan.org.service.EmployeeServiceImpl;

public class ClientTest {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = null;
		try {
			ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			EmployeeServiceImpl employeeService = ctx.getBean(EmployeeServiceImpl.class);
			//createEmployee(employeeService);

			getEmployeeById(employeeService);
			fetchAllEmployeesInfo(employeeService);
			employeeService.updateEmployeeEmailById("kk.cs@gmail.com", 1);
			employeeService.deleteEmployeeById(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ctx != null)
				ctx.close();
		}
	}

	private static void fetchAllEmployeesInfo(EmployeeServiceImpl employeeService) {
		employeeService.getAllEmployees().forEach(System.out::println);
	}

	private static void getEmployeeById(EmployeeServiceImpl employeeService) {
		Employee employee = employeeService.getEmployeeById(1);
		System.out.println(employee);
	}

	private static void createEmployee(EmployeeServiceImpl employeeService) {
		Employee employee = getEmployee();
		employeeService.createEmployee(employee);
	}

	private static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("Khan");
		employee.setEmail("khan@gmail.com");
		employee.setGender("Male");
		employee.setSalary(90000.00);
		return employee;
	}

}
