/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import utng.datos.BebidaDAO;
import utng.datos.MarcaDAO;
import utng.datos.UsuarioDAO;
import utng.modelo.Bebida;
import utng.modelo.Marca;

/**
 *
 * @author sarai
 */

@ManagedBean(name="bebidaBean") 
@SessionScoped
public class BebidaBean implements Serializable{
    private List<Bebida> bebidas;
    private Bebida bebida;
    private List<Marca> marcas;
    public BebidaBean(){
       bebida = new Bebida();
        bebida.setMarca(new Marca());
        
        
        
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public List<Marca> getMarca() {
        return marcas;
    }

    public void setMarca(List<Marca> marca) {
        this.marcas = marca;
    }

    
     public String listar(){
        BebidaDAO dao = new BebidaDAO();
        try {
            bebidas=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Bebidas";
    }
    
    public String eliminar(){
         BebidaDAO dao = new BebidaDAO();
        try {
            dao.delete(bebida);
            bebidas=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";//no me queda claro si este es es lo que devuelve 
    }
    
    public String iniciar(){
        bebida= new Bebida();
        bebida.setMarca(new Marca());
        try {
            marcas= new MarcaDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }
    
    public String guardar(){
        BebidaDAO dao = new BebidaDAO();
        try {
            if(bebida.getIdBebida()!= 0){
                dao.update(bebida);
            }else {
                dao.insert(bebida);
            }
            bebidas=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Bebida bebida){
        this.bebida=bebida;
        try {
            marcas = new MarcaDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
    
    
    
    
}
