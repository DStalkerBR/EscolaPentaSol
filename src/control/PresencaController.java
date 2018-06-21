package control;

import java.util.Date;
import java.util.List;
import model.bean.ListaPresenca;

public class PresencaController {
    //Função pra pegar alunos dado um professor
    public void inserir (List<ListaPresenca> presencas){
        ListaPresenca presenca = new ListaPresenca();
        for(int i=0; i < presencas.size(); i++)
            presencas.get(i).setData(new Date());
        presenca.inserir(presencas);        
    }
    
    public int checarPresenca (short idAluno, short idAula){
        ListaPresenca presenca = new ListaPresenca();
        return presenca.checarPresenca(idAluno, idAula);
    }
}