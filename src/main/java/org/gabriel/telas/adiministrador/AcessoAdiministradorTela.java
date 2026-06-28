package org.gabriel.telas.adiministrador;

import org.gabriel.telas.adiministrador.CadatroDeAdiministradorParaAdiministradorTela;
import org.gabriel.telas.adiministrador.CadastrarAlunoParaAdiministradorTela;
import org.gabriel.telas.adiministrador.CadastrarProfessorParaAdiministradorTela;
import org.gabriel.telas.utilidades.ClearUtil;
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
            ColoresUtil.printBlue("4 - Listar todos os Alunos");
            ColoresUtil.printBlue("5 - Listar Aluno por cpf");
            ColoresUtil.printBlue("6 - Listar todos os Professores");
            ColoresUtil.printBlue("7 - Listar Professor por cpf");
            ColoresUtil.printBlue("8 - Listar todos os Adiministradores");
            ColoresUtil.printBlue("9 - Listar Adiministrador por cpf");

            ColoresUtil.printBlue("10 - Sair");

            opc = scanner.nextByte();
            scanner.nextLine();

            switch (opc){
                case 1 -> CadatroDeAdiministradorParaAdiministradorTela.exibir(scanner);
                case 2 -> CadastrarProfessorParaAdiministradorTela.exibir(scanner);
                case 3 -> CadastrarAlunoParaAdiministradorTela.exibir(scanner);
                case 4 -> ClearUtil.LimparTerminal(0);
            }

        }while (opc!=10);
    }
}
