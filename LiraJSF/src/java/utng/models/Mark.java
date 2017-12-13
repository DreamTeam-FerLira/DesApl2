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
import javax.persistence.Table;

/**
 *
 * @author DLira
 */

@Entity
@Table(name="mark")
public class Mark implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_mark")
    private Long idMark;
    @Column(length=30)
    private String name;
    @Column(length=30)
    private String status;
     @Column(length=30)
    private String prestige;

    public Mark() {
        this.idMark=0L;
    }

    public Long getIdMark() {
        return idMark;
    }

    public void setIdMark(Long idMark) {
        this.idMark = idMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrestige() {
        return prestige;
    }

    public void setPrestige(String prestige) {
        this.prestige = prestige;
    }
    
}//End

     