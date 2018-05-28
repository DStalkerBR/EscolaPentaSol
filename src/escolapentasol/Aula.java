package escolapentasol;

import java.time.LocalTime;

public class Aula{
    private int idAula;
    private int tipoAula;
    private String instrumentoNecessario;
    private LocalTime horaInicio;
    private LocalTime horaFinal;

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public int getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(int tipoAula) {
        this.tipoAula = tipoAula;
    }

    public String getInstrumentoNecessario(){
        return this.instrumentoNecessario;
    }
    
    public void setInstrumentoNecessario(String instrumentoNecessario){
        this.instrumentoNecessario = instrumentoNecessario;
    }
    
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }
}
