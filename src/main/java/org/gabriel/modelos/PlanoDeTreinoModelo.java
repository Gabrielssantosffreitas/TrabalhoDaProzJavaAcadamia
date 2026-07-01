package org.gabriel.modelos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlanoDeTreinoModelo {
      private int id;

    private int alunoId;

    private int professorId;

    private LocalDate dataCriacao;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private String descricao;
}
