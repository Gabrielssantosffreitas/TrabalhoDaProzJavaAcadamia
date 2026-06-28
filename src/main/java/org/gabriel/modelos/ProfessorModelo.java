package org.gabriel.modelos;

import lombok.Getter;

public class ProfessorModelo extends PessoaModelo {
    @Getter
    private int id;

    public ProfessorModelo(int id, String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email, senha);
        this.id = id;
    }

    public ProfessorModelo(String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email, senha);
    }
}
