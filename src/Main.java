public class Main {
    public static void main(String[] args) {
        DigitalHouse digitalHouse = new DigitalHouse();

        digitalHouse.registrarProfessorTitular("Joao", "de Deus", 0, "Mestre");
        digitalHouse.registrarProfessorAdjunto("Kaique", "de Souza", 1, 40);
        digitalHouse.registrarCurso("Full Stack", 20001, 3);
        digitalHouse.registrarCurso("Android", 20002, 2);
        digitalHouse.matricularAluno("Carlos", "de Limeira", 3);
        digitalHouse.matricularAluno("Kaique", "de Janeiro", 6);
        digitalHouse.matricularAluno("Franck", "Aguiar", 7);
        digitalHouse.matricularAluno("Pepe", "Moreno", 8);
        digitalHouse.matricularAluno("Fabio", "Santos", 9);

        digitalHouse.matricularAluno(3, 20001);
        digitalHouse.matricularAluno(6, 20001);
        digitalHouse.matricularAluno(7, 20002);
        digitalHouse.matricularAluno(8, 20002);
        digitalHouse.matricularAluno(9, 20002);
    }
}
