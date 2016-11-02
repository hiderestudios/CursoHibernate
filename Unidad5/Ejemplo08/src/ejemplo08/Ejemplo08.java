/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo08;

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
public class Ejemplo08 {

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
        {
            System.out.println("--Usando List--");
            Query query = session.createQuery("SELECT p FROM Profesor p");
            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }
        {
            System.out.println("--Usando list con datos escalares en vez de con clases completas-- ");
            Query query = session.createQuery("SELECT p.id,p.nombre FROM Profesor p");
            List<Object[]> listDatos = query.list();
            for (Object[] datos : listDatos) {
                System.out.println(datos[0] + "--" + datos[1]);
            }
        }
        {
            System.out.println("--Usamos una lista cuando los datos escalares tienen solo una columna");
            Query query = session.createQuery("SELECT p.nombre FROM Profesor p");
            List<Object> listDatos = query.list();
            for (Object datos : listDatos) {
                System.out.println(datos);
            }
        }
        {
            System.out.println("Uso del uniqueResult");
            Profesor profesor = (Profesor) session.createQuery("SELECT p FROM Profesor p WHERE id=1001").uniqueResult();
            System.out.println("Profesor con Id 1001:  " + profesor.getNombre());
        }

        {
            System.out.println("-- PAGINACION --");
            int tamanyoPagina = 20;
            int paginaMostrar = 7;

            Query query = session.createQuery("SELECT p FROM Profesor p Order by p.id");
            query.setMaxResults(tamanyoPagina);
            query.setFirstResult(paginaMostrar * tamanyoPagina);
            List<Profesor> profesores = query.list();

            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }
        {

            int tamanyoPagina = 20;
            int paginaMostrar = 7;
            long numTotalObjetos = (Long) session.createQuery("SELECT count(*) FROM Profesor p").uniqueResult();
            int numPaginas = (int) Math.ceil((double) numTotalObjetos / (double) tamanyoPagina);
        }
        {
            
        }

        session.close();
        sessionFactory.close();

    }

}
