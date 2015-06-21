
package model;

import java.util.ArrayList;


public class Turma {
    
    private int idTurma;
    private String nome;
    private ArrayList listaDeAlunos = new ArrayList();

    public Turma() {
    }

    public Turma(String nome) {
        this.nome = nome;
    }

    public Turma(int idTurma, String nome) {
        this.idTurma = idTurma;
        this.nome = nome;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(ArrayList listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

}
