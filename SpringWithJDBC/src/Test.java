
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		DAOImpl bean = context.getBean("dAOImpl", DAOImpl.class);

		// create employee
		// createEmployee(bean);
		// get Employee
		// getEmployee(bean);
		// bean.updateEmployee(202, "Lolo Kumar");
		// deleteEmployee(bean);
		context.close();

	}

	private static void deleteEmployee(DAOImpl bean) {
		bean.deleteEmployee(202);
	}

	private static void getEmployee(DAOImpl bean) {
		Employee employee = bean.getEmployee(202);
		System.out.println("Employee Name is:" + employee.getEmpname() + " Employee Id is: " + employee.getEmpid());
	}

	private static void createEmployee(DAOImpl bean) {
		Employee employee = new Employee();
		employee.setEmpid(101);
		employee.setEmpname("Vishal Deep Verma");
		bean.createEmployee(employee);
	}
}
