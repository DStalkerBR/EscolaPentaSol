/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.util.List;
import model.bean.Administrador;
import model.dao.AdministradorDAO;

/**
 *
 * @author jhon_
 */
public class VisualizacaoAdministradores {

    public static List<Administrador> listar() {
        AdministradorDAO admDao = new AdministradorDAO();
        return admDao.listar();
    }
    
}
