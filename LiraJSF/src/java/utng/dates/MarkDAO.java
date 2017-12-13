/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dates;

import org.hibernate.HibernateException;
import utng.models.Mark;

/**
 *
 * @author LLira
 */
public class MarkDAO extends DAO<Mark> {
    public MarkDAO() {
        super(new Mark());
    }

    public Mark getOneById(Mark mark) throws HibernateException {
        return super.getOneById(mark.getIdMark()); //To change body of generated methods, choose Tools | Templates.
    }
}//End
