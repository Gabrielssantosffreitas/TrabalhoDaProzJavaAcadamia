package org.gabriel.telas;

import org.gabriel.repositorio.AdiministradorCRUDRepositorio;
import org.gabriel.servicos.ListarAdministradorPorCpf;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.util.Scanner;

public class ListarAdministradorPorCpfTela {
    private static AdiministradorCRUDRepositorio adiministradorCRUDRepositorio =  new AdiministradorCRUDRepositorio();
    private static ListarAdministradorPorCpf listarAdministradorPorCpf = new ListarAdministradorPorCpf(adiministradorCRUDRepositorio);
    public  static void  exibir (Scanner scanner) throws InterruptedException {

        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("===========================Listar Administrador Por CPF===========================");
        ColoresUtil.printBlue("Digite o Cpf");
        ColoresUtil.printCyan(listarAdministradorPorCpf.listar(scanner.nextLine()).toString());
    }
}
