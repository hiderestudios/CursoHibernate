
package ejemplo16.presentacion;

import ejemplo16.persistencia.dao.impl.ProfesorDAOImplHibernate;
import ejemplo16.persistencia.dao.ProfesorDAO;
import ejemplo16.dominio.Profesor;
import com.fpmislata.persistencia.dao.BussinessException;



public class ProfesorController {


    ProfesorDAO profesorDAO;

    public ProfesorController() {
        profesorDAO=new ProfesorDAOImplHibernate();
    }

    public void guardar(Profesor profesor) throws BussinessException {

            profesorDAO.saveOrUpdate(profesor);
    }

}
