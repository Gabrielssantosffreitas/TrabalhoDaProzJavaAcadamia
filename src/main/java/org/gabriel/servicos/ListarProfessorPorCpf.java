package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.modelos.ProfessorModelo;
import org.gabriel.repositorio.ProfessorCRUDRepositorio;

@AllArgsConstructor
public class ListarProfessorPorCpf {
    private ProfessorCRUDRepositorio professorCRUDRepositorio;

    public ProfessorModelo listar (String cpf){
        return professorCRUDRepositorio.selecionarPorCpf(cpf);
    }
}
