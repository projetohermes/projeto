
package model;


public class ListaDeRepresentantes {
    
    private int id;
    private String nome;
    private String curso;
    private String turma;

    public ListaDeRepresentantes() {
    }

    public ListaDeRepresentantes(int id, String nome, String curso, String turma) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.turma = turma;
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
