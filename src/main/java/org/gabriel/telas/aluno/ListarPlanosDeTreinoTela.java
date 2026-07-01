package org.gabriel.telas.aluno;

import java.util.Scanner;

import org.gabriel.repositorio.AlunoCRUDRepositorio;
import org.gabriel.repositorio.PlanoDeTreinoCRUDRepositorio;
import org.gabriel.servicos.ListarPlanosDeTreinoServico;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

public class ListarPlanosDeTreinoTela {
    private static PlanoDeTreinoCRUDRepositorio planoDeTreinoCRUDRepositorio = new PlanoDeTreinoCRUDRepositorio();
    private static AlunoCRUDRepositorio alunoCRUDRepositorio = new AlunoCRUDRepositorio();
    private static ListarPlanosDeTreinoServico listarPlanosDeTreinoServico = new ListarPlanosDeTreinoServico(planoDeTreinoCRUDRepositorio,alunoCRUDRepositorio);
    
    public static void exibir(Scanner s) throws InterruptedException{
        
        
    
        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("Lista do seus planos de treino");
        ColoresUtil.printBlue("1- Digite seu cpf");
        s.nextLine();
        var cpf = s.nextLine();
        var listar = listarPlanosDeTreinoServico.listar(cpf);
        var listarExercicos = listarPlanosDeTreinoServico.listarExercicos(cpf);

        listar.forEach(p -> {
            ColoresUtil.printYellow("------------------------------");
            ColoresUtil.printBlue("id " + p.getId());
            ColoresUtil.printBlue("descricao " + p.getDescricao());
            ColoresUtil.printBlue("data inical " + String.valueOf( p.getDataInicio()));
            ColoresUtil.printBlue("data final " +  String.valueOf( p.getDataFim()));

        });

        listarExercicos.forEach(p -> {
            ColoresUtil.printYellow("------------------------------");
            ColoresUtil.printBlue("id " + p.getId());
            ColoresUtil.printBlue("nome " + p.getNome());
            ColoresUtil.printBlue("series " + String.valueOf( p.getSeries()));
            ColoresUtil.printBlue("repeticao " +  String.valueOf( p.getRepeticoes()));
        });

        
    }
}
