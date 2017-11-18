package lflg_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lflg_dao.EmployeeDAOImpl;
import lflg_model.Employee;
import lflg_dao.EmployeeDAO;


/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee employee;
	private List<Employee> employees;
	private EmployeeDAOImpl employeeDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
		employee = new Employee();
		employees = new ArrayList<Employee>();
		employeeDAO = new EmployeeDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {

			employee.setName(request.getParameter("name"));
			employee.setFirstname(request.getParameter("firstname"));
			employee.setLastname(request.getParameter("lastname"));
			employee.setSalary(request.getParameter("salary"));
			employee.setGender(request.getParameter("gender"));
			employee.setAttention(request.getParameter("attention"));
			

			if (employee.getId() == 0) {
				employeeDAO.createEmployee(employee);
			} else {
				employeeDAO.updateEmployee(employee);
			}

			employees = employeeDAO.readAllEmployees();
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("employee_list.jsp").forward(request, response);

		} else if (request.getParameter("btn_new") != null) {
			employee = new Employee();
			request.getRequestDispatcher("employee_form.jsp").forward(request, response);

		} else if (request.getParameter("btn_edit") != null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				employee = employeeDAO.readEmployee(id);

			} catch (Exception e) {

				employee = new Employee();
			}
			request.setAttribute("employee", employee);

			request.getRequestDispatcher("employee_form.jsp").forward(request, response);

		} else if (request.getParameter("btn_delete") != null) {

			try {
				Long id = Long.parseLong(request.getParameter("id"));
				employeeDAO.deleteEmployee(id);
				employees = employeeDAO.readAllEmployees();

			} catch (Exception e) {
				e.printStackTrace();

			}
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("employee_list.jsp").forward(request, response);
		} else {
			employees = employeeDAO.readAllEmployees();
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("employee_list.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
