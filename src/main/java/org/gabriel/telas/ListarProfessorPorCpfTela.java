package org.gabriel.telas;

import org.gabriel.repositorio.ProfessorCRUDRepositorio;
import org.gabriel.servicos.ListarProfessorPorCpf;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.util.Scanner;

public class ListarProfessorPorCpfTela {
    private static ProfessorCRUDRepositorio professorCRUDRepositorio =  new ProfessorCRUDRepositorio();
    private static ListarProfessorPorCpf listarProfessorPorCpf = new ListarProfessorPorCpf(professorCRUDRepositorio);
    public  static void  exibir (Scanner scanner) throws InterruptedException {

        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("===========================Listar Professor Por CPF===========================");
        ColoresUtil.printBlue("Digite o Cpf");
        ColoresUtil.printCyan(listarProfessorPorCpf.listar(scanner.nextLine()).toString());
    }
}
