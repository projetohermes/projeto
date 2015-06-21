
package model;

import java.sql.Date;
import java.util.ArrayList;


public class SMS {
    
    private String mensagem;
    private Date data;
    Usuario usuario;
    private ArrayList listaDePessoas = new ArrayList();

    public SMS() {
    }

    public SMS(String mensagem, Date data, Usuario usuario) {
        this.mensagem = mensagem;
        this.data = data;
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList getListaDePessoas() {
        return listaDePessoas;
    }

    public void setListaDePessoas(ArrayList listaDePessoas) {
        this.listaDePessoas = listaDePessoas;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
