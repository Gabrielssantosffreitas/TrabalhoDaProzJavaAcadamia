package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.modelos.ExercicioModelo;
import org.gabriel.modelos.PlanoDeTreinoModelo;
import org.gabriel.repositorio.AlunoCRUDRepositorio;
import org.gabriel.repositorio.ExercicioCRUDrepositorio;
import org.gabriel.repositorio.PlanoDeTreinoCRUDRepositorio;

import java.util.List;

@AllArgsConstructor
public class ListarPlanosDeTreinoServico {
    private PlanoDeTreinoCRUDRepositorio planoDeTreinoCRUDRepositorio;
    private AlunoCRUDRepositorio alunoCRUDRepositorio;

    private int bucarPeloIdUsandoCpf(String cpf) {
        return alunoCRUDRepositorio.selecionarPorCpf(cpf).getId();
    }

    public List<PlanoDeTreinoModelo> listar(String cpf) {
        return planoDeTreinoCRUDRepositorio.selecionarPorAluno(this.bucarPeloIdUsandoCpf(cpf));
    }

    public List<ExercicioModelo> listarExercicos(String cpf) {
        return new ExercicioCRUDrepositorio().selecionarPorAluno(this.bucarPeloIdUsandoCpf(cpf));
    }
}
