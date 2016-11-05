/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo12;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author borja
 */
public class Ejemplo12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Profesor profesor = new Profesor( null, null, "Gomez");
        //--Session--
        Session session = sessionFactory.openSession();
        
        try{
            session.beginTransaction();
            session.save(profesor);
            session.getTransaction().commit();
            
        }catch(ConstraintViolationException cve){
            session.getTransaction().rollback();
            System.out.println("No se ha podido insertar el profesor por los siguientes errores: ");
            for (ConstraintViolation constraintViolation: cve.getConstraintViolations()){
                System.out.println("En el campo '" + constraintViolation.getPropertyPath()+ "':" + constraintViolation.getMessage());
            }
        }

//        
        session.close();
    
    }

}
