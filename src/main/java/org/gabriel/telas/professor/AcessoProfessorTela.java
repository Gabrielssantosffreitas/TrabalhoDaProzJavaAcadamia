package org.gabriel.telas.professor;

import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.util.Scanner;

public class AcessoProfessorTela {
    public static void exibir(Scanner scanner) throws InterruptedException {
        byte opc = 0;

        do {
            ClearUtil.LimparTerminal(0);
            ColoresUtil.printYellow("Bem vindo(a) ao painel do Professor!");
            ColoresUtil.printBlue("1- listar seus planos de treino feitos por voce");
            ColoresUtil.printCyan("2 - cadastrar um plano de treino para um aluno");
            ColoresUtil.printBlue("3 - sair");

            opc = scanner.nextByte();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    ListarPlanosProfessorTela.exibir(scanner);
                    break;
                case 2:
                    CadastrarPlanoDeTreinoTela.exibir(scanner);
                    break;
                default:
                    ColoresUtil.printRed("Essa opcao errada");
                    break;
            }
        } while (opc != 3);
    }
}
