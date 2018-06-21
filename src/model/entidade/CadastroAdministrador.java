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
        admin.setId( (short) 0);
        adminDao.inserir(admin);
    }
    
    public void editar(Administrador admin){
        AdministradorDAO adminDao = new AdministradorDAO();        
        adminDao.inserir(admin);
    }
    
    public void deletar (short idAdmin){
        AdministradorDAO adminDao = new AdministradorDAO();
        adminDao.delete(idAdmin);
    }
}
