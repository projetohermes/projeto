
package model;

import java.util.ArrayList;


public class TipoCurso {
    
    private int idTipoCurso;
    private String nome;

    public TipoCurso() {
    }

    public TipoCurso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getIdTipoCurso() {
        return idTipoCurso;
    }

    public void setIdTipoCurso(int idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCurso(int idTipoCurso, String nome) {
        this.idTipoCurso = idTipoCurso;
        this.nome = nome;
    }
}
