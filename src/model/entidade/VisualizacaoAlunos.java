/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.util.List;
import model.bean.Aluno;
import model.dao.AlunoDAO;

/**
 *
 * @author jhon_
 */
public class VisualizacaoAlunos {

    public static List<Aluno> listar() {
        AlunoDAO alunoDao = new AlunoDAO();
        return alunoDao.listar();
    }
    
    public static List<Aluno> listar(short idAula) {
        AlunoDAO alunoDao = new AlunoDAO();
        return alunoDao.listar(idAula);
    }
    
}
