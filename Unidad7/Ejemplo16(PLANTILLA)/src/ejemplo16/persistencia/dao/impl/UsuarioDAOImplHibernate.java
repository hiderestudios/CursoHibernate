/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo16.persistencia.dao.impl;

import ejemplo16.persistencia.dao.UsuarioDAO;
import ejemplo16.dominio.Usuario;
import com.fpmislata.persistencia.dao.impl.GenericDAOImplHibernate;

/**
 *
 * @author papa
 */
public class UsuarioDAOImplHibernate extends GenericDAOImplHibernate<Usuario,Integer> implements  UsuarioDAO {

}
