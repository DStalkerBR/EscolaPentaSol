package control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.bean.Aluno;
import model.bean.Aula;
import model.entidade.VisualizacaoAlunos;
import model.entidade.VisualizacaoAulas;

public class CertificadoController {
    private List<Aluno> alunosValidos;
    private List<Aula> aulas;    
    
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
                System.out.println((float) QuantPresenca.checarPresenca(aluno.getId(), idAula));
                System.out.println((float)VisualizacaoAulas.find(idAula).getQtdAula());
                if ((float) QuantPresenca.checarPresenca(aluno.getId(), idAula) / (float)VisualizacaoAulas.find(idAula).getQtdAula() >= 0.75 ){
                    aluno.setIdAula(new ArrayList<>(Collections.singletonList(idAula)));
                    this.alunosValidos.add(aluno);
                }
                    
            }                
        }
        if (this.alunosValidos.size() > 0)
            this.aulas = new ArrayList <>(VisualizacaoAulas.getTipos(alunos));
    }

    public List<Aluno> getAlunosValidos() {
        return this.alunosValidos;
    }

    public List<Aula> getTipoAulas() {
        return this.aulas;
    }   
    
    public static void main (String argv[]){
        CertificadoController cert = new CertificadoController();
        cert.listar();
        for (int i = 0; i < cert.getAlunosValidos().size(); i++)
            System.out.println(cert.getAlunosValidos().get(i).toString());
        for (int i = 0; i < cert.getTipoAulas().size(); i++)
            System.out.println(cert.getTipoAulas().get(i).toString());
    }
    
}