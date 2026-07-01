package org.gabriel.telas.aluno;

import java.util.Scanner;

import org.gabriel.modelos.ExercicioModelo;
import org.gabriel.repositorio.ExercicioCRUDrepositorio;
import org.gabriel.servicos.CadastrarExercicioService;
import org.gabriel.telas.utilidades.ColoresUtil;

public class CadastrarExerciciosTela {
    private static ExercicioCRUDrepositorio exercicioCRUDrepositorio = new ExercicioCRUDrepositorio();
    private static CadastrarExercicioService cadastrarExercicioService  = new CadastrarExercicioService(exercicioCRUDrepositorio); 

    public static void exibir (Scanner s){
        s.nextLine();
        ColoresUtil.printCyan("digite o nome do seu exercicio");
        var nome = s.nextLine();
        ColoresUtil.printBlue("digite a quantidade de series");
        var series = s.nextInt();
        ColoresUtil.printCyan("digite a quantidade de repeteçoes");
        var repeticoes = s.nextInt();
        ColoresUtil.printBlue("Digite o id do plano de treino");
        var plano = s.nextInt();
        cadastrarExercicioService.cadastrarExercico(new ExercicioModelo(plano,nome,series,repeticoes));



    }

}
