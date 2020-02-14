import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DigitalHouse {
    private List<Aluno> alunos;
    private List<Curso> cursos;
    private List<Professor> professores;
    private List<Matricula> matriculas;

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Integer verificarAluno(Integer codigoAluno){
        if (alunos == null) {
            alunos = new ArrayList<>();
            return -1;
        }
        for(int i = 0; i < alunos.size(); i++){
            if (codigoAluno.equals(alunos.get(i).getCodigo()))
                return i;
        }
        return -1;
    }

    public Integer verificarCurso(Integer codigoCurso){

        if (cursos == null) {
            cursos = new ArrayList<>();
            return -1;
        }
        for(int i = 0; i < cursos.size(); i++){
            if (codigoCurso.equals(cursos.get(i).getCodigo()))
                return i;
        }
        return -1;
    }

    public Integer verificarProfessor(Integer codigoCurso){
        if (professores == null) {
            professores = new ArrayList<>();
            return -1;
        }

        for(int i = 0; i < professores.size(); i++){
            if (codigoCurso.equals(professores.get(i).getCodigo()))
                return i;
        }
        return -1;
    }

    public void registrarCurso(String nome, Integer codigoCurso,Integer quantidadeMaxDeAlunos){
        if (verificarCurso(codigoCurso) < 0){
            Curso curso = new Curso(nome, codigoCurso, quantidadeMaxDeAlunos);
            this.cursos.add(curso);
            System.out.println("Curso adicionado com sucesso!");
        }else{
            System.out.println("Não foi possivel cadastrar o curso pois o codigo já esta cadastrado no sistema");
        }
    }

    public void excluirCurso(Integer codigoCurso){
        cursos.removeIf(curso -> curso.getCodigo().equals(codigoCurso));
        System.out.println("Curso removido com sucesso!");
    }

    public void registrarProfessorAdjunto(String nome, String sobrenome, Integer codigo, Integer qtdHorasMonitoria){
        if (verificarProfessor(codigo) < 0){
            ProfessorAdjunto professor = new ProfessorAdjunto(nome, sobrenome, codigo, qtdHorasMonitoria);
            professores.add(professor);
            System.out.println("Professor cadastrado!");
        }else{
            System.out.println("Não foi possivel cadastrar esse professor, pois o codigo já esta matriculado no sistema");
        }
    }

    public void registrarProfessorTitular(String nome, String sobrenome, Integer codigoProfessor, String especialidade){
        if (verificarProfessor(codigoProfessor) < 0){
            ProfessorTitular professor = new ProfessorTitular(nome, sobrenome, codigoProfessor, especialidade);
            professores.add(professor);
            System.out.println("Professor cadastrado!");
        }else{
            System.out.println("Não foi possivel cadastrar esse professor, pois o codigo já esta matriculado no sistema");
        }
    }

    public void excluirProfessor(Integer codigoProfessor){
        professores.removeIf(professor -> professor.getCodigo().equals(codigoProfessor));
        System.out.println("Professor removido com sucesso!");
    }

    public void matricularAluno(String nome, String sobrenome,Integer codigoAluno){
        if (verificarAluno(codigoAluno) < 0){
            Aluno aluno = new Aluno(nome, sobrenome, codigoAluno);
            alunos.add(aluno);
            System.out.println("Aluno matriculado com sucesso!");
        }else{
            System.out.println("Não foi possivel cadastrar esse aluno, pois o codigo já esta matriculado no sistema");
        }
    }

    public void matricularAluno(Integer codigoAluno, Integer codigoCurso){
        int posicaoCurso = verificarCurso(codigoCurso);
        int posicaoAluno = verificarAluno(codigoAluno);
        if (codigoCurso < 0) {
            System.out.println("O curso não esta matriculado no sistema");
            return;
        }
        if (codigoAluno < 0){
            System.out.println("O aluno não esta matriculado no sistema");
            return;
        }
        if (cursos.get(posicaoCurso).adicionarAluno(alunos.get(posicaoAluno))){
            Date hoje = new Date();
            Matricula matricula = new Matricula(cursos.get(posicaoCurso), alunos.get(posicaoAluno), hoje);
            if (matriculas == null) {
                matriculas = new ArrayList<>();
            }
            matriculas.add(matricula);
            System.out.println("Matricula realizada com sucesso!");
        }else{
            System.out.println("Não foi possivel matricular o aluno no curso!");
        }
    }

    public void alocarProfessores(Integer codigoCurso, Integer codigoProfessorTitular, Integer codigoProfessorAdjunto){
        int posicaoCurso = verificarCurso(codigoCurso);
        if(posicaoCurso > 0){
            alocarProfessorT(posicaoCurso, codigoProfessorTitular);
            alocarProfessorA(posicaoCurso, codigoProfessorAdjunto);
        }
    }

    private void alocarProfessorT(int posicaoCurso, int codigoProfessor){
        int posicaoProfessor = verificarProfessor(codigoProfessor);
        if(posicaoProfessor > 0){
            cursos.get(posicaoCurso).setProfessorTitular((ProfessorTitular) professores.get(codigoProfessor));
            System.out.println("Professor titular cadastrado!");
        }else{
            System.out.println("Professor titular não encontrado no sistema");
        }
    }

    private void alocarProfessorA(int posicaoCurso, int codigoProfessor){
        int posicaoProfessor = verificarProfessor(codigoProfessor);
        if(posicaoProfessor > 0){
            cursos.get(posicaoCurso).setProfessorAdjunto((ProfessorAdjunto) professores.get(codigoProfessor));
            System.out.println("Professor adjunto cadastrado!");
        }else{
            System.out.println("Professor adjunto não encontrado no sistema");
        }
    }
}
