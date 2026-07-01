package org.gabriel.servicos;

import org.gabriel.modelos.ExercicioModelo;
import org.gabriel.repositorio.ExercicioCRUDrepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CadastrarExercicioService {
    private ExercicioCRUDrepositorio exercicioCRUDrepositorio;
    public void cadastrarExercico ( ExercicioModelo exercicioModelo){
        exercicioCRUDrepositorio.criar(exercicioModelo);
    } 


}
