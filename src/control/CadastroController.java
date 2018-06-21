package control;

import java.util.Date;
import java.util.List;
import model.bean.*;
import model.entidade.CadastroAdministrador;
import model.entidade.CadastroAluno;
import model.entidade.CadastroAula;
import model.entidade.CadastroInstrumento;
import model.entidade.CadastroProfessor;

public class CadastroController {
  Aluno aluno;
  Professor prof;
  Administrador admin;
  Aula aula;
  Instrumento inst;
  
  public void cadastraAdministrador(String login, String senha,String nome, String dataNascimento, 
                                    String endereco, String celular, String email, String cpf, String tipoAdm){
      admin = new Administrador(login, senha, nome, dataNascimento, endereco, celular, email, cpf, tipoAdm);
      
      CadastroAdministrador cadAdmin = new CadastroAdministrador();
      cadAdmin.inserir(admin);
  }
  
  public void cadastrarProfessor(String login, String senha,String nome, String dataNascimento, 
                                    String endereco, String celular, String email, String cpf, List<Short> idAula, List<Short> especializacoes){
      prof = new Professor(login, senha, nome, dataNascimento, endereco, celular, email, cpf, idAula, especializacoes);
      
      CadastroProfessor cadProf = new CadastroProfessor();
      cadProf.inserir(prof);
  }

  public void cadastrarAluno(String nome, String dataNascimento, String endereco, String celular ,
            String email, String cpf, boolean possuiInstrumento, Date dataCadastro, List<Short> idAula){
    aluno = new Aluno(nome, dataNascimento, endereco, celular, email, cpf, possuiInstrumento, dataCadastro, idAula);
    CadastroAluno cadAluno = new CadastroAluno();
    cadAluno.inserir(aluno);
  }
  
  public void cadastrarAula(String tipoAula, String diaSemana, Date horaInicio, Date horaFim,  Date dataInicio, Date dataFim,
          String instrumentoNecessario, short idProfessor, short qtdAula){
      aula = new Aula(tipoAula, diaSemana, horaInicio, horaFim, dataInicio, dataFim, instrumentoNecessario, idProfessor, qtdAula);
      
      CadastroAula cadAula = new CadastroAula();
      cadAula.inserir(aula);
  }
  
  public void cadastrarInstrumento(String nome, String descricao, int qtdInstrumentos){
      inst = new Instrumento(nome, descricao, qtdInstrumentos);
      
      CadastroInstrumento cadInst = new CadastroInstrumento();
      cadInst.inserir(inst);
  }
  
  
  public static void main (String argv[]){
      
      /*CadastroController cadControl = new CadastroController();
      cadControl.cadastrarAluno("Joazin", "10/10/2000", "Lugar Nenhum", "juao@omail.com", "08097987633", 
              true, new Date(), new ArrayList<>(Arrays.asList((short)1,(short)2)));
      
      CadastroController cadControl = new CadastroController();
      cadControl.cadastrarAula("Violao", "Terça", new Date(),  new Date(), "Violao", (short)1, (short)60);            
    
      CadastroController cadControl = new CadastroController();
      cadControl.cadastrarInstrumento("Piano", "Steinway Model Z ", 1); 
      
      */ 
      
  }

  
  
 /* public void editarAluno(String nome, String dataNascimento, String endereco, String email, String cpf, boolean possuiInstrumento, short idAula){
    aluno = new Aluno(nome, dataNascimento, endereco, email, cpf, possuiInstrumento, idAula);
    aluno.editar();
  }
  
  public void apagarAluno(String cpf){
    aluno = new Aluno();
    aluno.apagar(cpf);
  }
  
  public void cadastrarProfessor(String nome, String dataNascimento, String endereco, String email, String cpf, boolean possuiInstrumento, short idAula){
    aluno = new Aluno(nome, dataNascimento, endereco, email, cpf, possuiInstrumento, idAula);
    aluno.inserir(Aluno);
  }
  
  public void editarProfessor(String nome, String dataNascimento, String endereco, String email, String cpf, boolean possuiInstrumento, short idAula){
    aluno = new Aluno(nome, dataNascimento, endereco, email, cpf, possuiInstrumento, idAula);
    aluno.editar();
  }
  
  public void apagarProfessor(short id){
    aluno = new Aluno();
    aluno.apagar(id);
  }
  */
}