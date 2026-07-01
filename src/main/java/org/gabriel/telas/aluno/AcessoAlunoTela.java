package org.gabriel.telas.aluno;

import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.util.Scanner;

public class AcessoAlunoTela {
    public static void exibir(Scanner scanner) throws InterruptedException {
       

        byte opc = 0;

        do{


        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("=====Bem vindo(a) ao painel do Aluno!===");
        ColoresUtil.printBlue("1- cadastrar Exercicos");
        ColoresUtil.printCyan("2 - listar Planos de treino");
        ColoresUtil.printBlue("3-  sair");

        opc = scanner.nextByte();
        
        switch (opc) {
          case 1:
            CadastrarExerciciosTela.exibir(scanner);
            break;
          case 2:
            ListarPlanosDeTreinoTela.exibir(scanner);
            break;
          default:
            ColoresUtil.printRed("Essa opcao errada");
            break;
        }

        }while(opc !=3);

       


    }
}
