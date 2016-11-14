package models;

import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.Model;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * Computer entity managed by Ebean
 */
@Entity 
public class Micro extends Model {

    private static final long serialVersionUID = 1L;
    
    @Id
    public Long id;

    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String valor1;
    
    @Constraints.Required
    public String valor2;

    
    @ManyToOne
    public Company company;
    
    /**
     * Generic query helper for entity Computer with id Long
     */
    public static Find<Long,Micro> find = new Find<Long,Micro>(){};
    
    /**
     * Return a paged list of computer
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Computer property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static PagedList<Micro> page(int page, int pageSize, String sortBy, String order, String filter) {
        return
            find.where()
                .ilike("name", "%" + filter + "%")
                .orderBy(sortBy + " " + order)
                .fetch("company")
                .findPagedList(page, pageSize);
    }
    
}

