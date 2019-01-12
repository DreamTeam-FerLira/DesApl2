/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sarai
 */

@Entity
@Table(name="marca")
public class Marca implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_marca")
    private Long idMarca;
    @Column(length=30)
    private String nombre;
    @Column(length=30)
    private String estado;
     @Column(length=30)
    private String prestigio;

    public Marca() {
        this.idMarca=0L;
    }

     
     
     
    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrestigio() {
        return prestigio;
    }

    public void setPrestigio(String prestigio) {
        this.prestigio = prestigio;
    }
     
     
}

     