package Domain;

public class Cliente {
    private String nome;
    private Integer idade;
    private Long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente(String nome, Integer idade, long id){
        this.nome = nome;
        this.idade = idade;
        this.id = id;
    }
}
