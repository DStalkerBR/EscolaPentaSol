/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.util.List;
import model.bean.Aula;
import model.dao.AulaDAO;

public class VisualizacaoAulas {
     public static List<Aula> listar() {
        AulaDAO aulaDao = new AulaDAO();
        return aulaDao.listar();
    }   
     
     public static List<Aula> listar(short idProf) {
        AulaDAO aulaDao = new AulaDAO();
        return aulaDao.listar(idProf);
    }    
}
