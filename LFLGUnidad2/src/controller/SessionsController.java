package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.SessionsDOM;
import model.Sessions;



/**
 * Servlet implementation class SessionsController
 */
@WebServlet("/SessionsController")
public class SessionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Sessions sessions;
	private List<Sessions> sessions1;
	private SessionsDOM sessionsDOM;
	private List<String> ids = new ArrayList<String>();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionsController() {
        super();
        // TODO Auto-generated constructor stub
        sessions = new Sessions("", "", "", 0, "");
        sessions1 = new ArrayList<Sessions>();
        sessionsDOM = new SessionsDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
	sessions.setSessKey(request.getParameter("sessKey"));
	sessions.setSecret(request.getParameter("secret"));
	sessions.setExpiry(Integer.parseInt(request.getParameter("expiry")));
	sessions.setData(request.getParameter("data"));
		
			
			try {
				
				sessions.setExpiry(Integer.parseInt(request.getParameter("expiry")));
			}catch(NumberFormatException e) {
				sessions.setExpiry(10);
				
				
			}
			
			if(sessions.getSessionId()=="") {
				int id = 1;
				String newId= "sess"+String.format("%05d", 1);
				sessions.setSessionId(newId);
				
				if (sessions.size()>0) {
					ids.clear();
					for (Sessions p: sessions1) {
						ids.add(p.getSessionId());
					}
					for (int i=0; i<= ids.size(); i++){
						newId= "soc"+ String.format("%05d", i+1);
						
						if (! ids.contains(newId)) {
							sessions.setSessionId(newId);
						break;
						}
					}
				}
				sessionsDOM.add(sessions);
			}else {
				sessionsDOM.update(sessions);
			}
			sessions = sessionsDOM.getSessions();
			request.setAttribute("sessions", sessions);
			request.getRequestDispatcher("sessions_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			sessions = new Sessions("", "", "", 0, "");
			request.getRequestDispatcher("sessions_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				String id = request.getParameter("id");
				sessions = sessionsDOM.findById(id);
				
			}catch (Exception e) {
				
				sessions = new Sessions("", "", "", 0, "");
			}
			request.setAttribute("sessions", sessions);
			
			request.getRequestDispatcher("sessions_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			String id = request.getParameter("id");
			sessionsDOM.delete(id);
			sessions1 = sessionsDOM.getPlayers();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("sessions1", sessions1);
			request.getRequestDispatcher("player_list.jsp").forward(request, response);
		}else {
			sessions1 = sessionsDOM.getPlayers();
			request.setAttribute("sessions1", sessions1);
			request.getRequestDispatcher("player_list.jsp").forward(request, response);
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
