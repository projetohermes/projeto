package model;

public class ListaDeTurma_Curso_Turno {

    private int id;
    private String nome;
    private String curso;
    private String turno;

    public ListaDeTurma_Curso_Turno() {
    }

    public ListaDeTurma_Curso_Turno(String nome, String curso, String turno) {
        this.nome = nome;
        this.curso = curso;
        this.turno = turno;
    }

    public ListaDeTurma_Curso_Turno(String nome) {
        this.nome = nome;
    }

    public ListaDeTurma_Curso_Turno(int id, String nome, String curso, String turno) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.turno = turno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
