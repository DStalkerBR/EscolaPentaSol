/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import model.bean.Instrumento;
import model.dao.InstrumentoDAO;

/**
 *
 * @author jhon_
 */
public class CadastroInstrumento {
   public void inserir(Instrumento instrumento){
        InstrumentoDAO instDao = new InstrumentoDAO();
        instDao.inserir(instrumento);
    }
}
