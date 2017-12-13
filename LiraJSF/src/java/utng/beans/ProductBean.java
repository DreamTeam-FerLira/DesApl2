/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import utng.dates.ProductDAO;
import utng.dates.MarkDAO;
import utng.dates.UserDAO;
import utng.models.Product;
import utng.models.Mark;

/**
 *
 * @author DLira
 */

@ManagedBean(name="productBean") 
@SessionScoped
public class ProductBean implements Serializable{
    private List<Product> products;
    private Product product;
    private List<Mark> marks;
    
    public ProductBean(){
       /*producto = new Producto();
       producto.setMarca(new Marca()); */
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> productos) {
        this.products = products;
    }

    public Product getProducto() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Mark> getMark() {
        return marks;
    }

    public void setMark(List<Mark> mark) {
        this.marks = mark;
    }

    
     public String listar(){
        ProductDAO dao = new ProductDAO();
        try {
            products=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Products";
    }
    
    public String eliminar(){
         ProductDAO dao = new ProductDAO();
        try {
            dao.delete(product);
            products=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String iniciar(){
        product = new Product();
        product.setMark(new Mark());
        try {
            marks= new MarkDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }
    
    public String guardar(){
        ProductDAO dao = new ProductDAO();
        try {
            if(product.getIdProduct()!= 0){
                dao.update(product);
            }else {
                dao.insert(product);
            }
            products=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancelar(){
    return "Cancel";
    }
    
    public String editar(Product product){
        this.product = product;
        try {
            marks = new MarkDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
    
}//End
