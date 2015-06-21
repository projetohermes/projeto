
package model;

import java.util.ArrayList;
import java.util.List;


public class ListaDeAlunos {
    
    private int matricula;
    private String nome;
    private String turma;
    private String curso;

    public ListaDeAlunos() {
    }

    public String getCurso() {
        return curso;
    }

    public ListaDeAlunos(int matricula, String nome, String turma, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.turma = turma;
        this.curso = curso;
    }
        
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
 }
