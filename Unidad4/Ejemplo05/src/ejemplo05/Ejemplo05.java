/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author borja
 */
public class Ejemplo05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Profesor profesor = new Profesor( "Eduardo", "Grau", "Aroca");
        Profesor profesor2 = new Profesor("Borja","Sahuquillo","Ferrer");
        
        
                ;
        //--Session--
        Session session = sessionFactory.openSession();
        //--GUARDAR--
        session.beginTransaction();
        session.delete(profesor);
        session.delete(profesor2);
        session.getTransaction().commit();
        session.close();


        
    
    }

}
