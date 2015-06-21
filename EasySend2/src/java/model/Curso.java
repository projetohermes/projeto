package model;

public class Curso {

    private int idCurso;
    private String nome;
    private String tipoCurso;

    public Curso() {
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public Curso(int idCurso, String nome) {
        this.idCurso = idCurso;
        this.nome = nome;
    }

    public Curso(int idCurso, String nome, String tipoCurso) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.tipoCurso = tipoCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }
}
