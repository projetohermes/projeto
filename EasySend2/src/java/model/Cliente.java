
package model;


public class Cliente {
    private String nome;
    private Integer numContato;//Pode ser Telefone ou Celular
    private Integer id;

    public Cliente( String nome, Integer numContato, Integer id) {
        this.nome = nome;
        this.id = id;
        this.numContato = numContato;
    }
    public String getNome(){
        return nome;
    }
    public Integer getNumContato(){
        return numContato;
    }
    public Integer getId(){
        return id;
    }
    public void setId( Integer id){
        this.id = id;
    }
    public void setNumContato( Integer numContato){
        this.numContato = numContato;
    }
    public void setNome( String nome){
        this.nome = nome;
    }
}
