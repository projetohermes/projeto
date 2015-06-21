
package model;


public class CursosAlunos {
    
    private String turma;
    private String curso;
    private String turno;

    public CursosAlunos() {
    }

    public CursosAlunos(String turma, String curso, String turno) {
        this.turma = turma;
        this.curso = curso;
        this.turno = turno;
    }

    public String getCurso() {
        return curso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
 
}
