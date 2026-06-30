package org.gabriel.servicos;

import org.gabriel.modelos.ProfessorModelo;
import org.gabriel.repositorio.ProfessorCRUDRepositorio;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListarTodosProfessoresService {
    private ProfessorCRUDRepositorio professorCRUDRepositorio;

   public List<ProfessorModelo> listar (){
       return professorCRUDRepositorio.selecionar();
   }
}
