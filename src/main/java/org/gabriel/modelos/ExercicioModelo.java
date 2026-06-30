package org.gabriel.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExercicioModelo {

    private int id;

    private int planoId;

    private String nome;

    private int series;

    private int repeticoes;

}