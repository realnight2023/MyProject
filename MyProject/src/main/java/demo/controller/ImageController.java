package demo.controller;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 import model.*;
 import java.util.*;

@Controller
public class ImageController {
	@RequestMapping("/picture")
	@ResponseBody  public List<Picture> generatePicPath(Model model) {         
        List<Picture>  data=Arrays.asList(new Picture(1,"JBud Ear Phone","images/p1.jpg","JBud Ear Phone") ,
        		          new Picture(2,"EDiMax Wifi","images/p2.jpg","EDiMax Wifi"),new Picture(3,"ASUS Computer","images/p3.jpg","ASUS Laptop Computer"));   
        return   data;         
    }
	@RequestMapping("/hbpicture")
	@ResponseBody  public List<Picture> generatehbPicPath(Model model) {         
        List<Picture>  data= null;
        SessionFactory factory=null;
		 try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex);	        
	      }
		
		
		  Session session = factory.openSession();
	      Transaction tx = null;
	      try {
		         tx = session.beginTransaction();
		         data =(List<Picture>)session.createQuery("FROM Picture").list(); 		       
		         tx.commit();
		         return data;
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		         factory.close();
		      }
        return   data;         
    }
}