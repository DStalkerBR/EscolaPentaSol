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

    public void cadastrarAdministrador(String login, String senha, String nome, String dataNascimento,
            String endereco, String celular, String email, String cpf, String tipoAdm) {
        admin = new Administrador(login, senha, nome, dataNascimento, endereco, celular, email, cpf, tipoAdm);

        CadastroAdministrador cadAdmin = new CadastroAdministrador();
        cadAdmin.inserir(admin);
    }

    public void cadastrarProfessor(String login, String senha, String nome, String dataNascimento,
            String endereco, String celular, String email, String cpf, List<Short> idAula, List<Short> especializacoes) {
        prof = new Professor(login, senha, nome, dataNascimento, endereco, celular, email, cpf, idAula, especializacoes);

        CadastroProfessor cadProf = new CadastroProfessor();
        cadProf.inserir(prof);
    }

    public void cadastrarAluno(String nome, String dataNascimento, String endereco, String celular,
            String email, String cpf, boolean possuiInstrumento, Date dataCadastro, List<Short> idAula) {
        aluno = new Aluno(nome, dataNascimento, endereco, celular, email, cpf, possuiInstrumento, dataCadastro, idAula);
        CadastroAluno cadAluno = new CadastroAluno();
        cadAluno.inserir(aluno);
    }

    public void cadastrarAula(String tipoAula, String diaSemana, Date horaInicio, Date horaFim, Date dataInicio, Date dataFim,
            String instrumentoNecessario, short idProfessor, short qtdAula) {
        aula = new Aula(tipoAula, diaSemana, horaInicio, horaFim, dataInicio, dataFim, instrumentoNecessario, idProfessor, qtdAula);

        CadastroAula cadAula = new CadastroAula();
        cadAula.inserir(aula);
    }

    public void cadastrarInstrumento(String nome, String descricao, int qtdInstrumentos) {
        inst = new Instrumento(nome, descricao, qtdInstrumentos);

        CadastroInstrumento cadInst = new CadastroInstrumento();
        cadInst.inserir(inst);
    }

    public void editarAdministrador(Short id, String login, String senha, String nome, String dataNascimento,
            String endereco, String celular, String email, String cpf, String tipoAdm) {
        admin = new Administrador(login, senha, nome, dataNascimento, endereco, celular, email, cpf, tipoAdm);
        admin.setId(id);
        CadastroAdministrador cadAdmin = new CadastroAdministrador();
        cadAdmin.inserir(admin);
    }

    public void editarProfessor(Short id, String login, String senha, String nome, String dataNascimento,
            String endereco, String celular, String email, String cpf, List<Short> idAula, List<Short> especializacoes) {
        prof = new Professor(login, senha, nome, dataNascimento, endereco, celular, email, cpf, idAula, especializacoes);
        prof.setId(id);
        CadastroProfessor cadProf = new CadastroProfessor();
        cadProf.inserir(prof);
    }

    public void editarAluno(Short id, String nome, String dataNascimento, String endereco, String celular,
            String email, String cpf, boolean possuiInstrumento, Date dataCadastro, List<Short> idAula) {
        aluno = new Aluno(nome, dataNascimento, endereco, celular, email, cpf, possuiInstrumento, dataCadastro, idAula);
        aluno.setId(id);
        CadastroAluno cadAluno = new CadastroAluno();
        cadAluno.inserir(aluno);
    }

    public void editarAula(Short id, String tipoAula, String diaSemana, Date horaInicio, Date horaFim, Date dataInicio, Date dataFim,
            String instrumentoNecessario, short idProfessor, short qtdAula) {
        aula = new Aula(tipoAula, diaSemana, horaInicio, horaFim, dataInicio, dataFim, instrumentoNecessario, idProfessor, qtdAula);
        aula.setId(id);
        CadastroAula cadAula = new CadastroAula();
        cadAula.inserir(aula);
    }

    public void editarInstrumento(Short id, String nome, String descricao, int qtdInstrumentos) {
        inst = new Instrumento(nome, descricao, qtdInstrumentos);
        inst.setId(id);
        CadastroInstrumento cadInst = new CadastroInstrumento();
        cadInst.inserir(inst);
    }
    
    public void deletarAdministrador(Short id) {
        CadastroAdministrador cadAdmin = new CadastroAdministrador();
        cadAdmin.deletar(id);
    }

    public void deletarProfessor(Short id) {
        CadastroProfessor cadProf = new CadastroProfessor();
        cadProf.deletar(id);
    }

    public void deletarAluno(Short id) {
        CadastroAluno cadAluno = new CadastroAluno();
        cadAluno.deletar(id);
    }

    public void deletarAula(Short id) {
        CadastroAula cadAula = new CadastroAula();
        cadAula.deletar(id);
    }

    public void deletarInstrumento(Short id) {
        CadastroInstrumento cadInst = new CadastroInstrumento();
        cadInst.deletar(id);
    }

    public static void main(String argv[]) {

        /*CadastroController cadControl = new CadastroController();
      cadControl.cadastrarAluno("Joazin", "10/10/2000", "Lugar Nenhum", "juao@omail.com", "08097987633", 
              true, new Date(), new ArrayList<>(Arrays.asList((short)1,(short)2)));
      
      CadastroController cadControl = new CadastroController();
      cadControl.cadastrarAula("Violao", "Terça", new Date(),  new Date(), "Violao", (short)1, (short)60);            
    
      CadastroController cadControl = new CadastroController();
      cadControl.cadastrarInstrumento("Piano", "Steinway Model Z ", 1); 
      
         */
    }
}
