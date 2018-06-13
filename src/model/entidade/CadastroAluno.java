package model.entidade;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.bean.Aluno;
import model.dao.AlunoDAO;

/**
 *
 * @author jhon_
 */
public class CadastroAluno {
    public void inserir(Aluno aluno){
        aluno.setListasPresenca(new ArrayList<>(Stream.of(0, 0, 0).collect(Collectors.toList())));
        AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.inserir(aluno);
    }
}
