import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private Integer codigo;
    private ProfessorTitular professorTitular;
    private ProfessorAdjunto professorAdjunto;
    private Integer qtdMaxAlunos;
    private List<Aluno> alunos;

    public Curso(String nome, Integer codigo, Integer qtdMaxAlunos) {
        this.nome = nome;
        this.codigo = codigo;
        this.qtdMaxAlunos = qtdMaxAlunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public ProfessorTitular getProfessorTitular() {
        return professorTitular;
    }

    public void setProfessorTitular(ProfessorTitular professorTitular) {
        this.professorTitular = professorTitular;
    }

    public ProfessorAdjunto getProfessorAdjunto() {
        return professorAdjunto;
    }

    public void setProfessorAdjunto(ProfessorAdjunto professorAdjunto) {
        this.professorAdjunto = professorAdjunto;
    }

    public Integer getQtdMaxAlunos() {
        return qtdMaxAlunos;
    }

    public void setQtdMaxAlunos(Integer qtdMaxAlunos) {
        this.qtdMaxAlunos = qtdMaxAlunos;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public boolean adicionarAluno(Aluno umAluno){
        if (alunos == null) {
            alunos = new ArrayList<>();
        }
        for(int i = 0; i < alunos.size(); i++){
            if (alunos.get(i).getCodigo().equals(umAluno.getCodigo())){
                return false;
            }
        }
        if(qtdMaxAlunos == alunos.size()) return false;


        setAlunos(umAluno);
        return true;
    }

    public void excluirAluno(Aluno umAluno){
        alunos.removeIf(aluno ->
            aluno.getCodigo().equals(umAluno.getCodigo())
        );
        System.out.println("Aluno excluido com sucesso.");
    }
}
