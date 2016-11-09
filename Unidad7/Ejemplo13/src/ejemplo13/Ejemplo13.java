package ejemplo13;

import org.hibernate.Session;
import persistencia.hibernate.util.HibernateUtil;



public class Ejemplo13 {

    public static void main(String[] args) {
        HibernateUtil.buildSessionFactory();
        
        
        try{
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            
            Profesor profesor = (Profesor) session.get(Profesor.class, 1001);
            System.out.println(profesor.toString());
        }finally{
            HibernateUtil.closeSessionAndUnbindFromThread();
        }
        HibernateUtil.closeSessionFactory();
        
        
        
        
    }
}
