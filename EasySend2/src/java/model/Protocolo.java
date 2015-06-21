
package model;

import java.util.ArrayList;


public class Protocolo {
    private Integer comando;
    private String mensagem;
    private Cliente emissor;
    private ArrayList<Cliente> destinatario;
    
    public Protocolo( Integer comando, String mensagem, Cliente emissor, ArrayList<Cliente> destinatario){
        this.comando = comando;
        this.mensagem = mensagem;
        this.emissor = emissor;
        this.destinatario = destinatario;
    }
   
    public Integer getComando() {
        return comando;
    }

    public void setComando(Integer comando) {
        this.comando = comando;
    }

    public ArrayList<Cliente> getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(ArrayList<Cliente> destinatario) {
        this.destinatario = destinatario;
    }

    public Cliente getEmissor() {
        return emissor;
    }

    public void setEmissor(Cliente emissor) {
        this.emissor = emissor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
}
