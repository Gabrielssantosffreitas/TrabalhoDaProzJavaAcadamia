package org.gabriel.telas.adiministrador;

import org.gabriel.servicos.CadastraAdiministradorServico;
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
            ColoresUtil.printCyan("2 - Cadastrar novo Funcionario");
            ColoresUtil.printBlue("2 - Cadastrar novo Aluno");
            ColoresUtil.printBlue("4 - Sair");

            opc = scanner.nextByte();
            scanner.nextLine();

            switch (opc){
                case 1 -> CadatroDeAdiministradorParaAdiministradorTela.exibir(scanner);
                case 2 -> CadatroDeAdiministradorParaAdiministradorTela.exibir(scanner);
                case 3 -> CadatroDeAdiministradorParaAdiministradorTela.exibir(scanner);
                case 4 -> ClearUtil.LimparTerminal(0);
            }

        }while (opc!=4);
    }
}
