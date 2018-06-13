package model.entidade;

import model.bean.Administrador;
import model.dao.AdministradorDAO;

/**
 *
 * @author jhon_
 */
public class CadastroAdministrador {
    public void inserir(Administrador admin){
        AdministradorDAO adminDao = new AdministradorDAO();
        adminDao.inserir(admin);
    }
}
