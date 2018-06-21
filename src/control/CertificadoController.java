package control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.bean.Aluno;
import model.bean.Aula;
import model.entidade.VisualizacaoAlunos;
import model.entidade.VisualizacaoAulas;

public class CertificadoController {
    List<Aluno> alunosValidos;
    List<Aula> aulas;    
    
    public CertificadoController(){
         alunosValidos = null;
         aulas = null;  
    }
    
    public void listar (){
        List<Aluno> alunos = new ArrayList<>(VisualizacaoAlunos.listar());
        this.alunosValidos = new ArrayList<>();
       
        PresencaController QuantPresenca = new PresencaController();
        for (Aluno aluno: alunos){ 
            for(Short idAula: aluno.getIdAula()){
                if ((float) QuantPresenca.checarPresenca(aluno.getId(), idAula) / (float)VisualizacaoAulas.find(idAula).getQtdAula() >= 0.75 ){
                    aluno.setIdAula(new ArrayList<>(Collections.singletonList(idAula)));
                    this.alunosValidos.add(aluno);
                }
                    
            }                
        }
        this.aulas = new ArrayList <>(VisualizacaoAulas.getTipos(alunos));
    }

    public List<Aluno> getAlunosValidos() {
        return this.alunosValidos;
    }

    public List<Aula> getTipoAulas() {
        return this.aulas;
    }   
    
}