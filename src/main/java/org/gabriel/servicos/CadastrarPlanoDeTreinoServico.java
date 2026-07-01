package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.execoe.ValorInvalidoExecaoExecao;
import org.gabriel.modelos.PlanoDeTreinoModelo;
import org.gabriel.repositorio.PlanoDeTreinoCRUDRepositorio;

@AllArgsConstructor
public class CadastrarPlanoDeTreinoServico {
    private PlanoDeTreinoCRUDRepositorio planoDeTreinoCRUDRepositorio;

    public void cadastrar(PlanoDeTreinoModelo plano) {
        this.validar(plano);
        planoDeTreinoCRUDRepositorio.criar(plano);
    }

    private void validar(PlanoDeTreinoModelo plano) {
        if (plano == null) {
            throw new ValorInvalidoExecaoExecao("Plano de treino invalido.");
        }
        if (plano.getAlunoId() <= 0) {
            throw new ValorInvalidoExecaoExecao("O aluno informado e invalido.");
        }
        if (plano.getProfessorId() <= 0) {
            throw new ValorInvalidoExecaoExecao("O professor informado e invalido.");
        }
        if (plano.getDescricao() == null || plano.getDescricao().isBlank()) {
            throw new ValorInvalidoExecaoExecao("A descricao e obrigatoria.");
        }
        if (plano.getDataInicio() == null || plano.getDataFim() == null) {
            throw new ValorInvalidoExecaoExecao("As datas de inicio e fim sao obrigatorias.");
        }
        if (plano.getDataInicio().isAfter(plano.getDataFim())) {
            throw new ValorInvalidoExecaoExecao("A data de inicio nao pode ser maior que a data final.");
        }
    }
}
