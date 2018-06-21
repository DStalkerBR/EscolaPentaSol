package control;

import java.util.ArrayList;
import model.entidade.VisualizacaoInstrumentos;
import model.entidade.VisualizacaoAdministradores;
import model.entidade.VisualizacaoProfessores;
import model.entidade.VisualizacaoAlunos;
import java.util.List;
import model.bean.Administrador;
import model.bean.Aluno;
import model.bean.Aula;
import model.bean.Instrumento;
import model.bean.Professor;
import model.entidade.VisualizacaoAulas;

public class VisualizacaoController {
    
    public List<Aluno> visualizarAlunos() {
        return VisualizacaoAlunos.listar();
    }    
    
    public List<Aluno> visualizarAlunos(short idAula) {
        return VisualizacaoAlunos.listar(idAula);
    }
    
    public List<Professor> visualizarProfessor() {
        return VisualizacaoProfessores.listar();
    }
    
    public List<Administrador> visualizarAdministrador() {
        return VisualizacaoAdministradores.listar();
    }
    
    public List<Instrumento> visualizarInstrumento() {
        return VisualizacaoInstrumentos.listar();
    }
    
    public List<Aula> visualizarAulas() {
        return VisualizacaoAulas.listar();
    }
    
    public List<Aula> visualizarAulas(short idProf) {
        return VisualizacaoAulas.listar(idProf);
    } 

    
    
    //Teste
    public static void main(String argv[]){
        /*VisualizacaoController visualiza = new VisualizacaoController();
        List<Aula> lista = new ArrayList<>(visualiza.visualizarAulas((short) 2));
        lista.forEach((aula) -> {
               System.out.println("ID" + aula.getId() + "NOME" + aula.getTipoAula() + "DESC" + aula.getDiaSemana()+ " QNT "+aula.getInstrumentoNecessario());
         });   
        
        VisualizacaoController visualiza = new VisualizacaoController();
        List<Professor> lista = new ArrayList<>(visualiza.visualizarProfessor());
        lista.forEach((professor) -> {
               System.out.println(professor.toString());
         });
        */ 
        
    } 
}
