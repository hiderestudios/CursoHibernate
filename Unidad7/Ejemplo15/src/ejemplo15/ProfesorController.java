
package ejemplo15;

import persistencia.hibernate.util.BussinessException;



public class ProfesorController {


    ProfesorDAO profesorDAO;

    public ProfesorController() {
        profesorDAO=new ProfesorDAOImplHibernate();
    }

    public void guardar(Profesor profesor) throws BussinessException {

            profesorDAO.saveOrUpdate(profesor);
    }

}
