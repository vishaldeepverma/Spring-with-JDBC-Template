package com.daoImpl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Employee;

public class DaoImpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	// Create employee
	public void createEmployee(Employee employee) {

		String sql = "insert into employee(empid,empname) values(?,?)";
		int update = jdbcTemplate.update(sql, new Object[] { employee.getEmpid(), employee.getEmpname() });
		if (update > 0) {
			System.out.println("Successfully Inserted");
		}

	}
	//deleteEmployee
	public void deleteEmployee(int empid) {

		String sql = "DELETE FROM employee WHERE empid=?";
		int update = jdbcTemplate.update(sql, new Object[] { empid });
		if (update > 0) {
			System.out.println("successfully deleted");
		}

	}
	//read employee
	public Employee getEmployeeById(int empid) {
		String sql = "select * from employee where empid=?";
		Employee employee = jdbcTemplate.queryForObject(sql, new Object[] { empid }, new EmployeeRowMapper());
		return employee;

	}
	//updateEmployee
	public void updateEmployeeById(int empid, String name) {

		String sql = "UPDATE employee SET empname = ? WHERE empid=?";
		int update = jdbcTemplate.update(sql, new Object[] { name, empid});
		if (update > 0) {
			System.out.println("successfully updated");
		}
	}
}
