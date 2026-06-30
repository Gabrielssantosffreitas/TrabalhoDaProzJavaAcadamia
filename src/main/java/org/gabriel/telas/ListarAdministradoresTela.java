package org.gabriel.telas;

import org.gabriel.repositorio.AdiministradorCRUDRepositorio;
import org.gabriel.servicos.ListarTodosAdministradoresService;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

public class ListarAdministradoresTela {
    private static AdiministradorCRUDRepositorio adiministradorCRUDRepositorio =  new AdiministradorCRUDRepositorio();
    private static ListarTodosAdministradoresService listarTodosAdministradoresService  = new ListarTodosAdministradoresService(adiministradorCRUDRepositorio);
    public  static void  exibir () throws InterruptedException {

        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("===========================Listar todos Os Administradores===========================");
        listarTodosAdministradoresService.listar().forEach(p ->{
            ColoresUtil.printPurple("----------------------------------------");
            ColoresUtil.printCyan("Nome: " + p.getNome());
            ColoresUtil.printBlue("Email: " +p.getEmail());
            ColoresUtil.printCyan("Cpf: " +p.getCpf());
            ColoresUtil.printBlue("Telefone : " +p.getTelefone());

        });
    }
}
