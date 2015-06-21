
package model;

import java.util.ArrayList;


public class Setor {
    
    private int idSetor;
    private String nome;

    public Setor() {
    }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }
    
    public Setor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor(int idSetor, String nome) {
        this.idSetor = idSetor;
        this.nome = nome;
    }

}
