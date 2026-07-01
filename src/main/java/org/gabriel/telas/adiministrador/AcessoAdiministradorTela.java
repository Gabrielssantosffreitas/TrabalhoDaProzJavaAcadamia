package org.gabriel.telas.adiministrador;

import org.gabriel.telas.ListarAlunoPorCpfTela;
import org.gabriel.telas.ListarAlunosTela;
import org.gabriel.telas.ListarProfessoresTela;
import org.gabriel.telas.ListarProfessorPorCpfTela;
import org.gabriel.telas.ListarAdministradoresTela;
import org.gabriel.telas.ListarAdministradorPorCpfTela;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class AcessoAdiministradorTela {
    public static void exibir(Scanner scanner) throws InterruptedException, NoSuchAlgorithmException {
        byte opc = 3;
        do {
            ColoresUtil.printYellow("==============Bem vindo a pagina do adiministrado==============");
            ColoresUtil.printBlue("1 - Cadastrar novo Adiministrador ");
            ColoresUtil.printCyan("2 - Cadastrar novo Professor");
            ColoresUtil.printBlue("3 - Cadastrar novo Aluno");
            ColoresUtil.printCyan("4 - Listar todos os Alunos");
            ColoresUtil.printBlue("5 - Listar Aluno por cpf");
            ColoresUtil.printCyan("6 - Listar todos os Professores");
            ColoresUtil.printBlue("7 - Listar Professor por cpf");
            ColoresUtil.printCyan("8 - Listar todos os Adiministradores");
            ColoresUtil.printBlue("9 - Listar Adiministrador por cpf");

            ColoresUtil.printRed("10 - Sair");

            opc = scanner.nextByte();
            scanner.nextLine();

            switch (opc){
                case 1:
                    CadatroDeAdiministradorParaAdiministradorTela.exibir(scanner);
                    break;
                case 2:
                    CadastrarProfessorParaAdiministradorTela.exibir(scanner);
                    break;
                case 3:
                    CadastrarAlunoParaAdiministradorTela.exibir(scanner);
                    break;
                case 4:
                    ListarAlunosTela.exibir();
                    break;
                case 5:
                    ListarAlunoPorCpfTela.exibir(scanner);
                    break;
                case 6:
                    ListarProfessoresTela.exibir();
                    break;
                case 7:
                    ListarProfessorPorCpfTela.exibir(scanner);
                    break;
                case 8:
                    ListarAdministradoresTela.exibir();
                    break;
                case 9:
                    ListarAdministradorPorCpfTela.exibir(scanner);
                    break;
            }

        }while (opc!=10);
    }
}
