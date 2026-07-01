package org.gabriel.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExercicioModelo {

    public ExercicioModelo (int planoId, String nome, int series, int repetiçoes){
        this.nome = nome ;
        this.series = series;
        this.repeticoes = repetiçoes;
        this.planoId = planoId;
    }
    private int id;

    private int planoId;

    private String nome;

    private int series;

    private int repeticoes;

}