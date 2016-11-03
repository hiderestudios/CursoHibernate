/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo10;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author borja
 */
public class ejemplo10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        String ape1 = (String) session.createQuery("SELECT p.direccion.municipio.nombre FROM Profesor p WHERE id=1100").uniqueResult();
        System.out.println("Apellido 1: " + ape1);

        session.close();
        sessionFactory.close();

    }

}
