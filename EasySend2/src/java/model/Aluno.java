
package model;

import java.sql.Date;
import java.util.ArrayList;


public class Aluno extends Pessoa{
    
    private int matricula;
    private ArrayList listaDeTurmas = new ArrayList();

    public Aluno() {
    }

    public Aluno(int matricula, String nome, String email, String telefone, Date dataNascimento) {
        super(nome, email, telefone, dataNascimento);
        this.matricula = matricula;
    }
    
    

    public Aluno(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public ArrayList getListaDeTurmas() {
        return listaDeTurmas;
    }

    public void setListaDeTurmas(ArrayList listaDeTurmas) {
        this.listaDeTurmas = listaDeTurmas;
    }

}
