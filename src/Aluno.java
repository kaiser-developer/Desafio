public class Aluno {
    private String nome;
    private String sobrenome;
    private Integer codigo;

    public Aluno(String nome, String sobrenome, Integer codigo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "" + codigo;
    }
}
