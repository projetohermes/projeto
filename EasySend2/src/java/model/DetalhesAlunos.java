
package model;

import java.sql.Date;

public class DetalhesAlunos {
    
    private int matricula;
    private String nome;
    private String telefone;
    private String email;
    private Date dataNascimento;
    private boolean representante;
    private boolean bolsista;
    private String turma;
    private String curso;
    private String turno;

    public DetalhesAlunos() {
    }

    public DetalhesAlunos(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public DetalhesAlunos(int matricula, String nome, String telefone, String email, Date dataNascimento, boolean representante, boolean bolsista, String turma, String curso, String turno) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.representante = representante;
        this.bolsista = bolsista;
        this.turma = turma;
        this.curso = curso;
        this.turno = turno;
    }
    
    
    public DetalhesAlunos(int matricula, String nome, String telefone, String email, Date dataNascimento, boolean representante, boolean bolsista) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.representante = representante;
        this.bolsista = bolsista;
    }

    public DetalhesAlunos(String turma, String curso, String turno) {
        this.turma = turma;
        this.curso = curso;
        this.turno = turno;
    }

    public boolean isBolsista() {
        return bolsista;
    }

    public void setBolsista(boolean bolsista) {
        this.bolsista = bolsista;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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

    public boolean isRepresentante() {
        return representante;
    }

    public void setRepresentante(boolean representante) {
        this.representante = representante;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
  
}
