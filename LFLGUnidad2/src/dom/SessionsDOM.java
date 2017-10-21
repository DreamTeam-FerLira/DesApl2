package dom;



import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Sessions;


public class SessionsDOM {
	private String pathFile = "C:\\Users\\LLira\\eclipse-workspace\\ProjectFutbolPlayer\\src\\data\\sessions.xml";
	public void add(Sessions data) {
		try {
			
				Document document = DOMHelper.getDocument(pathFile);
				Element sessions1 = document.getDocumentElement();
				
				//CREATE player TAG
				Element sessions = document.createElement("sessions");
				
				//CREAR ID TAGG
				Element sessionId = document.createElement("sessionId");
				sessionId.appendChild(document.createTextNode(data.getSessionId()));
				sessions.appendChild(sessionId);
				
				//Create tag sesskey
				Element sessKey = document.createElement("sessKey");
				sessKey.appendChild(document.createTextNode(data.getSessKey()));
				sessions.appendChild(sessKey);
				
				//Create tag sesskey
				Element secret = document.createElement("secret");
				secret.appendChild(document.createTextNode(data.getSecret()));
				sessions.appendChild(secret);
				
				
				//create age expiry
				Element expiry = document.createElement("expiry");
				expiry.appendChild(document.createTextNode(String.valueOf(data.getExpiry())));
				sessions.appendChild(expiry);
				
				sessions.appendChild(sessions);
				
				// Write to file
				DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			
				System.out.println(e.getMessage());
			
		}
	}
	
	public void delete (String id ) {
		
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("sessions");
			for (int i =0; i< nodelist.getLength(); i++) {
				
				Element sessions = (Element)nodelist.item(i);
				if (sessions.getElementsByTagName("sessionId").item(0).getTextContent().equals(id)) {
					sessions.getParentNode().removeChild(sessions);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update (Sessions data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("sessions");
			for (int i =0; i< nodelist.getLength(); i++) {
				Element sessions = (Element)nodelist.item(i);
				if (sessions.getElementsByTagName("sessionId").item(0).getTextContent().equals(data.getSessionId())) {
					sessions.getElementsByTagName("sessKey").item(0).setTextContent(data.getSessKey());
					sessions.getElementsByTagName("secret").item(0).setTextContent(data.getSecret());
					sessions.getElementsByTagName("expiry").item(0).setTextContent(String.valueOf(data.getExpiry()));
					sessions.getElementsByTagName("data").item(0).setTextContent(data.getData());
					
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Sessions findById(String id) {
		Sessions sessions = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("sessions");
			for(int i=0; i<nodelist.getLength(); i++) {
				Element s = (Element)nodelist.item(i);
				if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					sessions = new Sessions("","","",0,"");
					sessions.setSessionId(id);
					sessions.setSessKey(s.getElementsByTagName("sessKey").item(0).getTextContent());
					sessions.setSecret(s.getElementsByTagName("secret").item(0).getTextContent());
					sessions.setExpiry(Integer.parseInt(s.getElementsByTagName("expiry").item(0).getTextContent()));
					sessions.setData(s.getElementsByTagName("data").item(0).getTextContent());
					
				}
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sessions;
	}
	
	public  List<Sessions> getPlayers(){
		
		List<Sessions> players = new ArrayList<Sessions>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("player");
		for (int i =0; i<nodelist.getLength(); i++) {
			
			Element s = (Element)nodelist.item(i);
			Sessions sessions = new Sessions("", "", "", 0, "");
			sessions.setSessionId(s.getElementsByTagName("sessionId").item(0).getTextContent());
			sessions.setSessKey(s.getElementsByTagName("sessKey").item(0).getTextContent());
			sessions.setSecret(s.getElementsByTagName("secret").item(0).getTextContent());
			sessions.setExpiry(Integer.parseInt(s.getElementsByTagName("expiry").item(0).getTextContent()));
			sessions.setData(s.getElementsByTagName("data").item(0).getTextContent());
			
			sessions.add(sessions);
			
		}
		return sessions;
	}

	public Sessions getSessions() {
		// TODO Auto-generated method stub
		return null;
	}
}
