package model.entidade;


import model.bean.Aluno;
import model.dao.AlunoDAO;

/**
 *
 * @author jhon_
 */
public class CadastroAluno {
    public void inserir(Aluno aluno){
        AlunoDAO alunoDao = new AlunoDAO();
        aluno.setId( (short) 0);
        alunoDao.inserir(aluno);
    }
    
    public void editar(Aluno aluno){
        AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.inserir(aluno);
    }
    
    public void deletar (short idAluno){
        AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.delete(idAluno);
    }
}
