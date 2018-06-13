package model.entidade;

import model.bean.Aula;
import model.dao.AulaDAO;

/**
 *
 * @author jhon_
 */
public class CadastroAula {
     public void inserir(Aula aula){
     
         AulaDAO aulaDao = new AulaDAO();
         aulaDao.inserir(aula);
    }
}
