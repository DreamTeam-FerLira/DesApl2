package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.CategoryDOM;
import model.Category;




/**
 * Servlet implementation class CategoriesController
 */
@WebServlet("/CategoriesController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Category category;
	private List<Category> categories;
	private CategoryDOM categoriesDOM;
	private List<String> ids = new ArrayList<String>();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
        category = new Category();
        categories = new ArrayList<Category>();
        categoriesDOM = new CategoryDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
	category.setCategoryName(request.getParameter("categoryName"));
	category.setDescription(request.getParameter("description"));
	category.setPicture(request.getParameter("picture"));
	category.setInfo(request.getParameter("info"));
		
			
			/*try {
				
				category.setPicture(request.getParameter("picture"));
			}catch(NumberFormatException e) {
				category.setExpiry(10);
				
			}*/
			
			if(category.getId()=="") {
				//int id= 1;
				String newId= "cat"+ String.format("%02d", 1);
				category.setId(newId);
				
				if (categories.size()>0) {
					ids.clear();
					for (Category c: categories) {
						ids.add(c.getId());
					}
					
					for (int i=0; i<= ids.size(); i++){
						newId= "cat"+ String.format("%02d", i+1);
						
						if (!ids.contains(newId)) {
							category.setId(newId);
						break;
						}
					}
				}
				
				categoriesDOM.add(category);
			}else {
				categoriesDOM.update(category);
			}
			categories = categoriesDOM.getCategories();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("categories_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			category = new Category();
			request.getRequestDispatcher("categories_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				String id = request.getParameter("id");
				category = categoriesDOM.findById(id);
				
			}catch (Exception e) {
				
				category = new Category();
			}
			request.setAttribute("category", category);
			
			request.getRequestDispatcher("categories_form.jsp").forward(request, response);
			
		}

		
		//Button  delete	
		if(request.getParameter("btn_delete")!=null) {
			try {
				String id = request.getParameter("id");
				categoriesDOM.delete(id);
				categories = categoriesDOM.getCategories();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("categories_list.jsp").forward(request, response);
		}else {
			categories = categoriesDOM.getCategories();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("categories_list.jsp").forward(request, response);
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
