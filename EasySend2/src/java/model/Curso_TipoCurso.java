
package model;


public class Curso_TipoCurso {
    
    private String idCurso;
    private String curso;
    private String tipoCurso;

    public Curso_TipoCurso() {
    }

    public Curso_TipoCurso(String idCurso, String curso, String tipoCurso) {
        this.idCurso = idCurso;
        this.curso = curso;
        this.tipoCurso = tipoCurso;
    }

    public Curso_TipoCurso(String curso, String tipoCurso) {
        this.curso = curso;
        this.tipoCurso = tipoCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

}
