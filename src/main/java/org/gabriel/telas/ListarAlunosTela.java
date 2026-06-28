package org.gabriel.telas;

import org.gabriel.repositorio.AlunoCRUDRepositorio;
import org.gabriel.servicos.ListarTodosOSAlunosService;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

public class ListarAlunosTela {
    private static AlunoCRUDRepositorio alunoCRUDRepositorio =  new AlunoCRUDRepositorio();
    private static ListarTodosOSAlunosService listarTodosOSAlunosService  = new ListarTodosOSAlunosService(alunoCRUDRepositorio);
    public  static void  exibir () throws InterruptedException {

        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("===========================Listar todos Os Alunos===========================");
        listarTodosOSAlunosService.listar().forEach(p ->{
            ColoresUtil.printPurple("----------------------------------------");
            ColoresUtil.printCyan("Nome: " + p.getNome());
            ColoresUtil.printBlue("Email: " +p.getEmail());
            ColoresUtil.printCyan("Cpf: " +p.getCpf());
            ColoresUtil.printBlue("Telefone : " +p.getTelefone());
            ColoresUtil.printCyan("Id: " +String.valueOf(p.getId()));

        });
    }
}
