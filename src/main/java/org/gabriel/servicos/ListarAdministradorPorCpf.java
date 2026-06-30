package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.modelos.AdiministradorModelo;
import org.gabriel.repositorio.AdiministradorCRUDRepositorio;

@AllArgsConstructor
public class ListarAdministradorPorCpf {
    private AdiministradorCRUDRepositorio adiministradorCRUDRepositorio;

    public AdiministradorModelo listar (String cpf){
        return adiministradorCRUDRepositorio.selecionarPorCpf(cpf);
    }
}
