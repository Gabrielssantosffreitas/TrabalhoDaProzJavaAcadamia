package org.gabriel.modelos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class AlunoModelo extends PessoaModelo{
    @Getter
    private int id;

    public AlunoModelo (int id,String nome,String cpf, String telefone, String email, String senha ){
        super(nome,cpf,telefone,email,senha);
        this.id = id;
    }

    public AlunoModelo (String nome,String cpf, String telefone, String email, String senha ){
        super(nome,cpf,telefone,email,senha);
    }

    @Override
    public String toString() {
        return "AlunoModelo{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", id=" + id +
                '}';
    }
}
