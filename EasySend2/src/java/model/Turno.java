package model;

import java.util.ArrayList;

public class Turno {

    private String nome;
    private ArrayList listaDeTurmas = new ArrayList();
    private int idTurno;

    public Turno() {
    }

    public Turno(String nome) {
        this.nome = nome;
    }

    public Turno(int idTurno, String nome) {
        this.idTurno = idTurno;
        this.nome = nome;  
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList getListaDeTurmas() {
        return listaDeTurmas;
    }

    public void setListaDeTurmas(ArrayList listaDeTurmas) {
        this.listaDeTurmas = listaDeTurmas;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }
    
}
