package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.modelos.AlunoModelo;
import org.gabriel.repositorio.AlunoCRUDRepositorio;

import java.util.List;

@AllArgsConstructor
public class ListarAlunoPorCpf {
    private AlunoCRUDRepositorio alunoCRUDRepositorio;

    public AlunoModelo listar (String cpf){
        return alunoCRUDRepositorio.selecionarPorCpf(cpf);
    }
}
