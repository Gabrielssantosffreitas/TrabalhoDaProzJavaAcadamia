package org.gabriel.telas;

import org.gabriel.repositorio.ProfessorCRUDRepositorio;
import org.gabriel.servicos.ListarTodosProfessoresService;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

public class ListarProfessoresTela {
    private static ProfessorCRUDRepositorio professorCRUDRepositorio =  new ProfessorCRUDRepositorio();
    private static ListarTodosProfessoresService listarTodosProfessoresService  = new ListarTodosProfessoresService(professorCRUDRepositorio);
    public  static void  exibir () throws InterruptedException {

        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("===========================Listar todos Os Professores===========================");
        listarTodosProfessoresService.listar().forEach(p ->{
            ColoresUtil.printPurple("----------------------------------------");
            ColoresUtil.printCyan("Nome: " + p.getNome());
            ColoresUtil.printBlue("Email: " +p.getEmail());
            ColoresUtil.printCyan("Cpf: " +p.getCpf());
            ColoresUtil.printBlue("Telefone : " +p.getTelefone());
            ColoresUtil.printCyan("Id: " +String.valueOf(p.getId()));

        });
    }
}
