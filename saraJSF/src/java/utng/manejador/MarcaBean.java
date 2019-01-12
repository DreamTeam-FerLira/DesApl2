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
import utng.datos.MarcaDAO;
import utng.modelo.Marca;

/**
 *
 * @author sarai
 */
@SessionScoped
@ManagedBean(name="marcaBean") 

public class MarcaBean implements Serializable{
    private List<Marca>marcas;
    private Marca marca;
    public MarcaBean(){}

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

        public String listar(){
        MarcaDAO dao = new  MarcaDAO();
        try {
            marcas=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Marcas";
    }
    
    public String eliminar(){
          MarcaDAO dao = new MarcaDAO();
        try {
            dao.delete(marca);
            marcas=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        marca= new Marca();
        return "Iniciar";
    }
    
    public String guardar(){
         MarcaDAO dao = new  MarcaDAO();
        try {
            if(marca.getIdMarca()!= 0){
                dao.update(marca);
            }else {
                dao.insert(marca);
            }
            marcas=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Marca marca){
        this.marca=marca;
        return "Editar";
    }
}