package control;

import java.util.ArrayList;
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
    
    public static void main (String argv[]){
        /*PresencaController presenca = new PresencaController();
        List<ListaPresenca> lista = new ArrayList<>();
        ListaPresenca lista1 = new ListaPresenca();
        lista1.setIdAluno((short) 2);
        lista1.setIdAula((short) 5);
        lista1.setPresente(true);
        lista.add(lista1);
        lista1 = new ListaPresenca();
        lista1.setIdAluno((short) 2);
        lista1.setIdAula((short) 5);
        lista1.setPresente(false);
        lista.add(lista1);
        lista1 = new ListaPresenca();
        lista1.setIdAluno((short) 2);
        lista1.setIdAula((short) 5);
        lista1.setPresente(true);
        lista.add(lista1);
        lista1 = new ListaPresenca();
        lista1.setIdAluno((short) 2);
        lista1.setIdAula((short) 5);
        lista1.setPresente(true);
        lista.add(lista1);
        lista1 = new ListaPresenca();
        lista1.setIdAluno((short) 2);
        lista1.setIdAula((short) 5);
        lista1.setPresente(true);
        lista.add(lista1);
        presenca.inserir(lista);
        
        PresencaController presenca = new PresencaController();
        System.out.println(presenca.checarPresenca((short) 2 , (short) 5));
    */
    }
}