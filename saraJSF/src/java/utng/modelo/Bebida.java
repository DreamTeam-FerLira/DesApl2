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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sarai
 */
@Entity
@Table(name="bebida")
public class Bebida implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_bebida")
    private Long idBebida;
    @Column(name="nombre_bebida", length=10)
    private String nombreBebida;
    @Column(length=40)
    private String tamaño;
     @Column(length=40)
    private String color;
    
    @ManyToOne()
    @JoinColumn(name="id_marca")
    private Marca marca;

    public Bebida() {
        this.idBebida=0L;
    }

    public Bebida(Long idBebida, String nombreBebida, String tamaño, String color, Marca marca) {
        super();
        this.idBebida = idBebida;
        this.nombreBebida = nombreBebida;
        this.tamaño = tamaño;
        this.color = color;
        this.marca = marca;
    }
    
    

    
    public Long getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Long idBebida) {
        this.idBebida = idBebida;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
}