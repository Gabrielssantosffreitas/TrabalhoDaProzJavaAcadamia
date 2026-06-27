package org.gabriel.telas;

import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.util.Scanner;

public class InicialTela {

    public static void exibir(Scanner s) throws InterruptedException {
        ClearUtil.LimparTerminal(0);

        ColoresUtil.printYellow("===================/BEM VINDO/===================");
        byte opc = 0;
        do {

            ColoresUtil.printWhite("Selecione uma das opcoes");

            ColoresUtil.printBlue("1 - Logar como adiministrador");
            ColoresUtil.printCyan("2 - Logar como aluno");
            ColoresUtil.printBlue("3 - Logar como Professor");
            ColoresUtil.printCyan("4 - Sair");

            opc = s.nextByte();

            switch (opc){
                case 1 -> LoginAdiministrador.exibir(s);
                case 2 -> LoginAdiministrador.exibir(s);
                case 3 -> LoginAdiministrador.exibir(s);
                case 4 -> ColoresUtil.printRed("Saindo");
                default -> ColoresUtil.printRed("opcao invalida");
            }

        }while (opc!=4);



    }
}
