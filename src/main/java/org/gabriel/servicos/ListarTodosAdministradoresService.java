package org.gabriel.servicos;

import org.gabriel.modelos.AdiministradorModelo;
import org.gabriel.repositorio.AdiministradorCRUDRepositorio;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListarTodosAdministradoresService {
    private AdiministradorCRUDRepositorio adiministradorCRUDRepositorio;

   public List<AdiministradorModelo> listar (){
       return adiministradorCRUDRepositorio.selecionar();
   }
}
