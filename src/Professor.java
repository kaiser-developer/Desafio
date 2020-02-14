public class Professor {
    private String nome;
    private String sobrenome;
    private Integer tempoDeCasa;
    private Integer codigo;

    public Professor(String nome, String sobrenome, Integer codigo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tempoDeCasa = 0;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Integer getTempoDeCasa() {
        return tempoDeCasa;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setTempoDeCasa(Integer tempoDeCasa) {
        this.tempoDeCasa += tempoDeCasa;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
