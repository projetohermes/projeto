
package model;

import java.sql.Date;


public class Pessoa {
    
    private int idPessoa;
    private String nome;
    private String email;
    private String telefone;
    private Date dataNascimento;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String telefone, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa(int idPessoa, String nome) {
        this.idPessoa = idPessoa;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    
}
