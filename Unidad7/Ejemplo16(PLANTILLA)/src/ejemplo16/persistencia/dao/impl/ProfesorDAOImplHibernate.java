package ejemplo16.persistencia.dao.impl;

import ejemplo16.persistencia.dao.ProfesorDAO;
import ejemplo16.dominio.Profesor;
import com.fpmislata.persistencia.dao.impl.GenericDAOImplHibernate;

public class ProfesorDAOImplHibernate extends GenericDAOImplHibernate<Profesor,Integer> implements  ProfesorDAO {

}
