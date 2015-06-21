
package model;

import java.sql.Date;


public class Funcionario extends Pessoa{
    
    private int matricula;

    public Funcionario() {
    }

    public Funcionario(int matricula, String nome, String email, String telefone, Date dataNascimento) {
        super(nome, email, telefone, dataNascimento);
        this.matricula = matricula;
    }

    public Funcionario(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}
