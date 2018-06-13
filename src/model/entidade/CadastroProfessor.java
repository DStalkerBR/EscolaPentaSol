/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import model.bean.Professor;
import model.dao.ProfessorDAO;

/**
 *
 * @author jhon_
 */
public class CadastroProfessor {
    public void inserir(Professor prof){
        ProfessorDAO profDao = new ProfessorDAO();
        profDao.inserir(prof);
    }
}
