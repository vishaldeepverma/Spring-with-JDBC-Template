package com.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.daoImpl.DaoImpl;
import com.model.Employee;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		DaoImpl daoImpl = context.getBean("daoImpl", DaoImpl.class);

		// createEmployee(daoImpl);

		// deleteEmployee(daoImpl);

		//getEmployeeById(daoImpl);
		
		//updateEmployee(daoImpl);

		context.close();
	}

	private static void updateEmployee(DaoImpl daoImpl) {
		daoImpl.updateEmployeeById(101, "Mayank");
	}

	private static void getEmployeeById(DaoImpl daoImpl) {
		System.out
				.println(daoImpl.getEmployeeById(101).getEmpname() + "----" + daoImpl.getEmployeeById(101).getEmpid());
	}

	private static void deleteEmployee(DaoImpl daoImpl) {
		daoImpl.deleteEmployee(202);
	}

	private static void createEmployee(DaoImpl daoImpl) {
		Employee employee = new Employee();
		employee.setEmpid(202);
		employee.setEmpname("Lala Kumar Yadav");
		
		daoImpl.createEmployee(employee);
	}
}
