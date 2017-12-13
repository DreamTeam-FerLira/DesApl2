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
import utng.dates.MarkDAO;
import utng.models.Mark;

/**
 *
 * @author DLira
 */
@SessionScoped
@ManagedBean(name="markBean") 

public class MarkBean implements Serializable{
    private List<Mark>marks;
    private Mark mark;
    
    public MarkBean(){
    
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

        public String list(){
        MarkDAO dao = new  MarkDAO();
        try {
            marks=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Marks";
    }
    
    public String delete(){
          MarkDAO dao = new MarkDAO();
        try {
            dao.delete(mark);
            marks=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        mark= new Mark();
        return "Start";
    }
    
    public String save(){
         MarkDAO dao = new  MarkDAO();
        try {
            if(mark.getIdMark()!= 0){
                dao.update(mark);
            }else {
                dao.insert(mark);
            }
            marks=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Mark mark){
        this.mark=mark;
        return "Edit";
    }
}//End