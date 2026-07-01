package org.gabriel.telas.professor;

import org.gabriel.modelos.PlanoDeTreinoModelo;
import org.gabriel.repositorio.AlunoCRUDRepositorio;
import org.gabriel.repositorio.PlanoDeTreinoCRUDRepositorio;
import org.gabriel.repositorio.ProfessorCRUDRepositorio;
import org.gabriel.servicos.CadastrarPlanoDeTreinoServico;
import org.gabriel.servicos.utilidades.RegexUtil;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CadastrarPlanoDeTreinoTela {
    private static PlanoDeTreinoCRUDRepositorio planoDeTreinoCRUDRepositorio = new PlanoDeTreinoCRUDRepositorio();
    private static AlunoCRUDRepositorio alunoCRUDRepositorio = new AlunoCRUDRepositorio();
    private static ProfessorCRUDRepositorio professorCRUDRepositorio = new ProfessorCRUDRepositorio();
    private static CadastrarPlanoDeTreinoServico cadastrarPlanoDeTreinoServico = new CadastrarPlanoDeTreinoServico(planoDeTreinoCRUDRepositorio);

    public static void exibir(Scanner s) throws InterruptedException {
        ClearUtil.LimparTerminal(0);
        ColoresUtil.printRed("===== Cadastro de Plano de Treino =====");

        ColoresUtil.printBlue("Digite o CPF do aluno");
        var cpfAluno = s.nextLine();

        ColoresUtil.printBlue("Digite o CPF do professor logado");
        var cpfProfessor = s.nextLine();

        ColoresUtil.printBlue("Digite a descricao do plano");
        var descricao = s.nextLine();

        ColoresUtil.printBlue("Digite a data de inicio (dd/MM/yyyy)");
        var dataInicioTexto = s.nextLine();

        ColoresUtil.printBlue("Digite a data final (dd/MM/yyyy)");
        var dataFimTexto = s.nextLine();

        if (!RegexUtil.eCpf(cpfAluno) || !RegexUtil.eCpf(cpfProfessor)) {
            ColoresUtil.printRed("Os CPFs devem conter apenas 11 numeros.");
            return;
        }

        if (!RegexUtil.eData(dataInicioTexto) || !RegexUtil.eData(dataFimTexto)) {
            ColoresUtil.printRed("As datas devem seguir o formato dd/MM/yyyy.");
            return;
        }

        try {
            var aluno = alunoCRUDRepositorio.selecionarPorCpf(cpfAluno);
            var professor = professorCRUDRepositorio.selecionarPorCpf(cpfProfessor);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataInicio = LocalDate.parse(dataInicioTexto, formatter);
            LocalDate dataFim = LocalDate.parse(dataFimTexto, formatter);

            var plano = new PlanoDeTreinoModelo(
                    0,
                    aluno.getId(),
                    professor.getId(),
                    LocalDate.now(),
                    dataInicio,
                    dataFim,
                    descricao
            );

            cadastrarPlanoDeTreinoServico.cadastrar(plano);
            ColoresUtil.printGreen("Plano de treino cadastrado com sucesso!");
        } catch (Exception e) {
            ColoresUtil.printRed(e.getMessage());
        }
    }
}
