package dom;



import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Category;


public class CategoryDOM {
	private String pathFile = "C:\\Users\\LLira\\eclipse-workspace\\LFLGUnidad22\\src\\data\\categories.xml";
	public void add(Category data) {
		try {
			
				Document document = DOMHelper.getDocument(pathFile);
				Element categories = document.getDocumentElement();
				
				//CREATE player TAG
				Element category = document.createElement("category");
				
				//CREAR ID TAGG
				Element id = document.createElement("id");
				id.appendChild(document.createTextNode(data.getId()));
				category.appendChild(id);
				
				//Create tag categoryName
				Element categoryName = document.createElement("categoryName");
				categoryName.appendChild(document.createTextNode(data.getCategoryName()));
				category.appendChild(categoryName);
				
				//Create tag description
				Element description = document.createElement("description");
				description.appendChild(document.createTextNode(data.getDescription()));
				category.appendChild(description);
				
				
				//create age picture
				Element picture = document.createElement("picture");
				picture.appendChild(document.createTextNode(data.getPicture()));
				category.appendChild(picture);
				
				//create age picture
				Element info = document.createElement("info");
				info.appendChild(document.createTextNode(data.getInfo()));
				category.appendChild(info);
				
				categories.appendChild(category);
				
				// Write to file
				DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			
				System.out.println(e.getMessage());
			
		}
	}
	
	public void delete (String id ) {
		
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("category");
			for (int i =0; i< nodelist.getLength(); i++) {
				
				Element category = (Element)nodelist.item(i);
				if (category.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					category.getParentNode().removeChild(category);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update (Category data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("category");
			for (int i =0; i< nodelist.getLength(); i++) {
				Element category = (Element)nodelist.item(i);
				if (category.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					category.getElementsByTagName("categoryName").item(0).setTextContent(data.getCategoryName());
					category.getElementsByTagName("description").item(0).setTextContent(data.getDescription());
					category.getElementsByTagName("picture").item(0).setTextContent(data.getPicture());
					category.getElementsByTagName("info").item(0).setTextContent(data.getInfo());
					
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Category findById(String id) {
		Category category = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("category");
			for(int i=0; i<nodelist.getLength(); i++) {
				Element s = (Element)nodelist.item(i);
				if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					category = new Category();
					category.setId(id);
					category.setCategoryName(s.getElementsByTagName("categoryName").item(0).getTextContent());
					category.setDescription(s.getElementsByTagName("description").item(0).getTextContent());
					category.setPicture(s.getElementsByTagName("picture").item(0).getTextContent());
					category.setInfo(s.getElementsByTagName("info").item(0).getTextContent());	
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}
	
	public  List<Category> getCategories(){
		
		List<Category> categories = new ArrayList<Category>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("category");
		for (int i =0; i<nodelist.getLength(); i++) {
			
			Element s = (Element)nodelist.item(i);
			Category category = new Category();
			category.setId(s.getElementsByTagName("id").item(0).getTextContent());
			category.setCategoryName(s.getElementsByTagName("categoryName").item(0).getTextContent());
			category.setDescription(s.getElementsByTagName("description").item(0).getTextContent());
			category.setPicture(s.getElementsByTagName("picture").item(0).getTextContent());
			category.setInfo(s.getElementsByTagName("info").item(0).getTextContent());
			
			categories.add(category);
			
		}
		return categories;
	}

	
}//End
