/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Marca;

/**
 *
 * @author sarai
 */

public class MarcaDAO extends DAO<Marca> {
     public MarcaDAO() {
        super(new Marca());
    }

    
    public Marca getOneById(Marca marca) throws HibernateException {
        return super.getOneById(marca.getIdMarca()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
