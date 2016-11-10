package ejemplo16.presentacion;

import ejemplo16.persistencia.dao.impl.UsuarioDAOImplHibernate;
import ejemplo16.persistencia.dao.UsuarioDAO;
import ejemplo16.dominio.Usuario;
import com.fpmislata.persistencia.dao.BussinessException;



public class UsuarioController {
    UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO=new UsuarioDAOImplHibernate();
    }

    public void guardar(Usuario usuario) throws BussinessException {
            usuarioDAO.saveOrUpdate(usuario);
    }
}
