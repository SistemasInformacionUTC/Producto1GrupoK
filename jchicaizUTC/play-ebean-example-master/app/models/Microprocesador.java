package models;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.avaje.ebean.PagedList;
import com.avaje.ebean.Model.Find;

import play.data.format.Formats;
import play.data.validation.Constraints;

public class Microprocesador {

	 private static final long serialVersionUID = 1L;

		@Id
	    public Long id;
	    
	    @Constraints.Required
	    public String name;
	    
	    @Formats.DateTime(pattern="yyyy-MM-dd")
	    public Date introduced;
	    
	    @Formats.DateTime(pattern="yyyy-MM-dd")
	    public Date discontinued;
	    
	    
	    @ManyToOne
	    public Company company;
	   
	    @Constraints.Required
	    public int numero;
	    
	    @Constraints.Required
	    public int peso;
	   
	    @ManyToOne
	    public Computer computer;
	    
	   	    /**
	     * Generic query helper for entity Computer with id Long
	     */
	    public static Find<Long,Microprocesador> find = new Find<Long,Microprocesador>(){};
	   
	   
	    
	    public static PagedList<Microprocesador> page(int page, int pageSize, String sortBy, String order, String filter) {
	        return
	            find.where()
	                .ilike("name", "%" + filter + "%")
	                .orderBy(sortBy + " " + order)
	                .fetch("computer")
	                .findPagedList(page, pageSize);
	    }
	   
	    
}
