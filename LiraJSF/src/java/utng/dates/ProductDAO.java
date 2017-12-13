/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dates;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.models.Product;

/**
 *
 * @author DLira
 */
public class ProductDAO  extends DAO<Product>{
    public ProductDAO() {
        super(new Product());
    }
    public Product getOneById(Product product) throws HibernateException {
        return super.getOneById(product.getIdProduct()); 
    }
}
    