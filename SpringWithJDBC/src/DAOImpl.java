import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DAOImpl {

	private Connection connection;
	private PreparedStatement prepareStatement;
	private int executeUpdate;
	private String sql;
	private ResultSet rs;

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// Create employee
	public void createEmployee(Employee employee) {

		try {
			connection = dataSource.getConnection();
			String sql = "insert into employee values (?,?)";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, employee.getEmpid());
			prepareStatement.setString(2, employee.getEmpname());
			executeUpdate = prepareStatement.executeUpdate();
			if (executeUpdate > 0) {
				System.out.println("Successfully Done!!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Read Operation
	public Employee getEmployee(int empid) {

		Employee employee = null;
		try {
			connection = dataSource.getConnection();
			sql = "select * from employee where empid=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, empid);
			rs = prepareStatement.executeQuery();
			rs.next();
			employee = new Employee();
			employee.setEmpid(rs.getInt("empid"));
			employee.setEmpname(rs.getString("empname"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	// update operation
	public void updateEmployee(int empid, String empname) {
		try {
			connection = dataSource.getConnection();
			sql = "update employee set empname=? where empid=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(2, empid);
			prepareStatement.setString(1, empname);
			executeUpdate = prepareStatement.executeUpdate();
			if (executeUpdate > 0) {
				System.out.println("Successfullt updated");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// delete Operation
	public void deleteEmployee(int empid) {
		try {
			connection = dataSource.getConnection();
			sql = "delete from employee where empid=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, empid);

			executeUpdate = prepareStatement.executeUpdate();
			if (executeUpdate > 0) {
				System.out.println("Successfullt updated");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
