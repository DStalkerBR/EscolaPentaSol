package services;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

//Validar Data
public class AutenticacaoData {

    LocalDate dataAtual = LocalDate.now();
    LocalDate dataNascimento, checkIn, checkOut;
    int dia, mes, ano;
    final int[] vetDiasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public AutenticacaoData() {
        dataAtual = LocalDate.now();
    }

    public boolean validaData(String dataInput) {
        if (dataInput.matches("\\d{2}/\\d{2}/\\d{4}")) {
            dia = Integer.valueOf(dataInput.substring(0, 2));
            mes = Integer.valueOf(dataInput.substring(3, 5));
            ano = Integer.valueOf(dataInput.substring(6, 10));

            if (mes >= 1 && mes <= 12) {
                if(dia >= 1 && dia <= vetDiasMes[mes - 1]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    //Data de Nascimento
    public boolean validarNascimento(String dataInput) {
        if (validaData(dataInput)) {
            dataNascimento = LocalDate.of(ano, mes, dia);
            if(DAYS.between(dataNascimento, dataAtual) > 6570 && DAYS.between(dataNascimento, dataAtual) < 43800){
                return true;
            } else{
                return false;
            }
        } else {
            return false;
        }
    }
}
