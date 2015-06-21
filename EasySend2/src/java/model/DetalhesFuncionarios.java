
package model;

import java.util.Date;


public class DetalhesFuncionarios {
    
    private String nome;
    private String email;
    private String telefone;
    private Date dataNascimento;
    private int matricula;
    private String setor;

    public DetalhesFuncionarios() {
    }
    

    public DetalhesFuncionarios(String nome, String email, String telefone, Date dataNascimento, int matricula, String setor) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
        this.setor = setor;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
