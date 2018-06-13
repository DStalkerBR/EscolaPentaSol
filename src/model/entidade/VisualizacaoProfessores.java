/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.util.List;
import model.bean.Professor;
import model.dao.ProfessorDAO;

/**
 *
 * @author jhon_
 */
public class VisualizacaoProfessores {

    public static List<Professor> listar() {
        ProfessorDAO profDao = new ProfessorDAO();
        return profDao.listar();
    }    
}
