/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import java.util.List;
import model.bean.Instrumento;
import model.dao.InstrumentoDAO;

/**
 *
 * @author jhon_
 */
public class VisualizacaoInstrumentos {

    public static List<Instrumento> listar() {
        InstrumentoDAO intDao = new InstrumentoDAO();
        return intDao.listar();
    }    
}
   
