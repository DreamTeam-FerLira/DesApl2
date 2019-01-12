/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.modelo.Bebida;

/**
 *
 * @author sarai
 */
public class BebidaDAO  extends DAO<Bebida>{

    public BebidaDAO() {
        super(new Bebida());
    }
    public Bebida getOneById(Bebida bebida) throws HibernateException {
        return super.getOneById(bebida.getIdBebida()); 
    }
}
    