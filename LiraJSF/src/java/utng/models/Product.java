/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.models;

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
 * @author LLira
 */
@Entity
@Table(name="product")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_product")
    private Long idProduct;
    
    @Column(name="name_product", length=10)
    private String nameProduct;
    
    @Column(length=40)
    private String size;
    
    @Column(length=40)
    private String colour;
     
    @ManyToOne()
    @JoinColumn(name="id_mark")
    private Mark mark;

    public Product() {
        this.idProduct=0L;
    }

    public Product(Long idProduct, String nameProduct, String size, String colour, Mark mark) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.size = size;
        this.colour = colour;
        this.mark = mark;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
    
    
     
}//End