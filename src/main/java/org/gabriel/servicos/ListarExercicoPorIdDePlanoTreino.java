package org.gabriel.servicos;

import org.gabriel.repositorio.ExercicioCRUDrepositorio;
import org.gabriel.modelos.ExercicioModelo;
import java.util.List;


public class ListarExercicoPorIdDePlanoTreino {
    private static ExercicioCRUDrepositorio ex =  new ExercicioCRUDrepositorio();
    private static List<ExercicioModelo> listar (int id ){
        return  ex.selecionarPorId(id);
    }

}
