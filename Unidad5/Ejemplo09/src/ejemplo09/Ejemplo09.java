/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo09;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author borja
 */
public class Ejemplo09 {

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
        String nombre = "ISIDRO";
        String ape1 = "CORTINA";
        String ape2 = "GARCIA";

        { //PARAMETROS POR POSICION
            Query query = session.createQuery("SELECT p from Profesor p where nombre=? AND ape1=? AND ape2=?");
            query.setString(0, nombre);
            query.setString(1, ape1);
            query.setString(2, ape2);

            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }
        {//PARAMETROS POR NOMBRE
            Query query = session.createQuery("SELECT p FROM Profesor p where nombre=:nombre AND ape1=:ape1 AND ape2=:ape2");
            query.setString("nombre", nombre);
            query.setString("ape1", ape1);
            query.setString("ape2", ape2);

            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }

        }

        //-.-.-MEJORAS-.-.-
        {//setParameter
            Query query = session.createQuery("SELECT p FROM Profesor p where nombre=:nombre AND ape1=:ape1 AND ape2=:ape2");
            query.setParameter("nombre", nombre);
            query.setParameter("ape1", ape1);
            query.setParameter("ape2", ape2);

            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.getNombre());
            }
        }
        {//Metodos encadenados 
            Query query = session.createQuery("SELECT p FROM Profesor p where nombre=:nombre AND ape1=:ape1 AND ape2=:ape2")
                    .setParameter("nombre", nombre)
                    .setParameter("ape1", ape1)
                    .setParameter("ape2", ape2);
            
            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.getNombre());
            }
        }

        session.close();
        sessionFactory.close();

    }

}
