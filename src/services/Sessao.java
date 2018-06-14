/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import model.bean.Administrador;
import model.bean.Professor;

/**
 *
 * @author jhon_
 */
public class Sessao {
    private static Sessao instancia = null;
    private Administrador admin;
    private Professor prof;

    public Sessao() {
    }
    
    public static Sessao getInstance(){
        if (instancia == null)
            instancia = new Sessao();
        return instancia;        
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }  
}
