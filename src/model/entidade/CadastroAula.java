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
         aula.setId( (short) 0);
         aulaDao.inserir(aula);
    }
     
     public void editar(Aula aula){
        AulaDAO aulaDao = new AulaDAO();
        aulaDao.inserir(aula);
    }
    
    public void deletar (short idAula){
        AulaDAO aulaDao = new AulaDAO();
        aulaDao.delete(idAula);
    }
}
