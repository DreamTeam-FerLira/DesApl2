package lflg_report;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lflg_dao.EmployeeDAOImpl;
import lflg_model.Employee;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class StudentReport
 */
@WebServlet("/EmployeeReport")
public class EmployeeReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAOImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeReport() {
        super();
        dao = new EmployeeDAOImpl() {
			
			@Override
			public void updateEmployee(Employee employee) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Employee readEmployee(Long id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Employee> readAllEmployees() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deleteEmployee(Long id) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void createEmployee(Employee employee) {
				// TODO Auto-generated method stub
				
			}
		};
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "C:\\Users\\DLira\\eclipse-workspace\\LFLG_Unidad3\\src\\lflg_report\\employeeReport.jrxml";
		try {
			
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("logo", this.getServletContext().getRealPath("/") + "/images/lira.jpg");
			
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnetion());
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
			
			
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
