package model.bean;

import java.util.Date;

public class Aula{
    private short id;
    private String tipoAula;
    private String diaSemana; //Exemplo: Segunda-feira, etc.
    private Date horaInicio;
    private Date horaFim;    
    private String instrumentoNecessario;
    private short idProfessor; //Identificador do Professor da aula
    private short qtdAula; //Quantidade de Aulas

    public Aula() {
    }
    
    public Aula(String tipoAula, String diaSemana, Date horaInicio, Date horaFim, String instrumentoNecessario, short idProfessor, short qtdAula) {
        this.tipoAula = tipoAula;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.instrumentoNecessario = instrumentoNecessario;
        this.idProfessor = idProfessor;
        this.qtdAula = qtdAula;
    } 
      
    //Identificador da Aula
    public int getId() {
        return this.id;
    }

    public void setId(short id) {
        this.id =  id;
    }

    //Identificador do Professor vinculado a aula.
    public int getIdProfessor(){
      return this.idProfessor;
    }
    
    public void setIdProfessor(short idProfessor){
      this.idProfessor = idProfessor;
    }
  
    //Tipo de Aula -> Violão Básico, Violino, Guitarra, etc. 
    public String getTipoAula() {
        return this.tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    //Dia das aulas na semana
    public String getDiaSemana(){
      return this.diaSemana;
    }
  
    public void setDiaSemana(String diaSemana){
      this.diaSemana = diaSemana;    
    }
  
    //Horário das aulas
    public Date getHoraInicio(){
      return this.horaInicio;
    }
  
    public void setHoraInicio(Date horaInicio){
      this.horaInicio = horaInicio;    
    }
  
    public Date getHoraFim(){
      return this.horaFim;
    }
  
    public void setHoraFim(Date horaFim){
      this.horaFim = horaFim;   
    }
  
    //Quantidade da Aula em relação ao curso. Exemplo: Aula de Violão Básico tem duração de 40 dias.
    public int getQtdAula(){
      return this.qtdAula;
    }
  
    public void setQtdAula(short qtdAula){
      this.qtdAula = qtdAula;
    } 
  
    //Verifica qual o instrumento necessário para a aula 
    public String getInstrumentoNecessario(){
        return this.instrumentoNecessario;
    }
    
    public void setInstrumentoNecessario(String instrumentoNecessario){
        this.instrumentoNecessario = instrumentoNecessario;
    }
    
    
}