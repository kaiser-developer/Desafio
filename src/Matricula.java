import java.util.Date;

public class Matricula {
    private Curso curso;
    private Aluno aluno;
    private Date data;

    public Matricula(Curso curso, Aluno aluno, Date data) {
        this.curso = curso;
        this.aluno = aluno;
        this.data = data;
    }

    public Curso getCurso() {
        return curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Date getData() {
        return data;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
