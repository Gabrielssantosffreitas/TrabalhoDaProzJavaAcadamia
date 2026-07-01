package org.gabriel.telas.professor;

import org.gabriel.repositorio.PlanoDeTreinoCRUDRepositorio;
import org.gabriel.repositorio.ProfessorCRUDRepositorio;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.util.Scanner;

public class ListarPlanosProfessorTela {
    private static PlanoDeTreinoCRUDRepositorio planoDeTreinoCRUDRepositorio = new PlanoDeTreinoCRUDRepositorio();
    private static ProfessorCRUDRepositorio professorCRUDRepositorio = new ProfessorCRUDRepositorio();

    public static void exibir(Scanner s) throws InterruptedException {
        ClearUtil.LimparTerminal(0);
        ColoresUtil.printRed("===== Planos de treino do professor =====");
        ColoresUtil.printBlue("Digite o CPF do professor logado");
        var cpf = s.nextLine();

        try {
            var professor = professorCRUDRepositorio.selecionarPorCpf(cpf);
            var planos = planoDeTreinoCRUDRepositorio.selecionarPorProfessor(professor.getId());

            if (planos.isEmpty()) {
                ColoresUtil.printRed("Nenhum plano encontrado para esse professor.");
                return;
            }

            planos.forEach(plano -> {
                ColoresUtil.printRed("------------------------------");
                ColoresUtil.printBlue("id " + plano.getId());
                ColoresUtil.printBlue("descricao " + plano.getDescricao());
                ColoresUtil.printBlue("data inicial " + plano.getDataInicio());
                ColoresUtil.printBlue("data final " + plano.getDataFim());
            });
        } catch (Exception e) {
            ColoresUtil.printRed(e.getMessage());
        }
    }
}
