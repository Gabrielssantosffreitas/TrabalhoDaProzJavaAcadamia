package org.gabriel.telas;

import org.gabriel.repositorio.AlunoCRUDRepositorio;
import org.gabriel.servicos.ListarAlunoPorCpf;
import org.gabriel.servicos.ListarTodosOSAlunosService;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.util.Scanner;

public class ListarAlunoPorCpfTela {
    private static AlunoCRUDRepositorio alunoCRUDRepositorio =  new AlunoCRUDRepositorio();
    private static ListarAlunoPorCpf listarAlunoPorCpf = new ListarAlunoPorCpf(alunoCRUDRepositorio);
    public  static void  exibir (Scanner scanner) throws InterruptedException {

        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("===========================Listar todos Os Alunos===========================");
        ColoresUtil.printBlue("Digite o Cpf");
        ColoresUtil.printCyan(listarAlunoPorCpf.listar(scanner.nextLine()).toString());
    }
}
