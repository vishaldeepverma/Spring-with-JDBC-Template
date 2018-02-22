package com.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int empid) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpid(rs.getInt("empid"));
		employee.setEmpname(rs.getString("empName"));
		return employee;
	}
}
