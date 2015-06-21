
package model;

import java.sql.Date;
import java.util.ArrayList;


public class Usuario extends Funcionario{
    
    private String login;
    private String senha;
    private ArrayList listaDeSMS = new ArrayList();

    public Usuario() {
    }

    public Usuario(String login, String senha, int matricula) {
        super(matricula);
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha, int matricula, String nome, String email, String telefone, Date dataNascimento) {
        super(matricula, nome, email, telefone, dataNascimento);
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList getListaDeSMS() {
        return listaDeSMS;
    }

    public void setListaDeSMS(ArrayList listaDeSMS) {
        this.listaDeSMS = listaDeSMS;
    }

}
