/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
public class Ejemplo11 {

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

        {//PROBLEMA CON n+1 SELECTs

            Query query = session.createQuery("SELECT p FROM Profesor p LEFT JOIN FETCH p.correosElectronicos");
            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
                for (CorreoElectronico correoElectronico : profesor.getCorreosElectronicos()) {
                    System.out.println("\t" + correoElectronico.getDireccionCorreo());
                }
            }
        }
        { //SOLUCION CON n+1 selects
            System.out.println("----------- SOLUCION al n+1 SELECT con join -----------");
            Query query = session.createQuery("SELECT p FROM Profesor p LEFT JOIN FETCH p.correosElectronicos");
            List<Profesor> profesores = query.list();

            Set<Profesor> profesoresSinDuplicar = new LinkedHashSet<Profesor>(profesores);
            profesores.clear();
            profesores.addAll(profesoresSinDuplicar);

            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
                for (CorreoElectronico correoElectronico : profesor.getCorreosElectronicos()) {
                    System.out.println("\t" + correoElectronico.getDireccionCorreo());
                }
            }
        }

        { // CONSULTAS NATIVAS SQL
            System.out.println("----------- consulta nativa en SQL -----------");
            Query query = session.createSQLQuery("SELECT IdCiclo,nombreCiclo,Horas FROM CicloFormativo");
            List<Object[]> listDatos = query.list();

            for (Object[] datos : listDatos) {
                System.out.println(datos[0] + "-" + datos[1] + " " + datos[2] + " Horas");
            }
        }

        session.close();

    }
}
