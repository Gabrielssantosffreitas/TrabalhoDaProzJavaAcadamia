package org.gabriel.modelos;
import lombok.*;


@ToString
public class AdiministradorModelo extends PessoaModelo {
    public  AdiministradorModelo (String nome,String cpf, String telefone, String email, String senha ){
        super(nome, cpf, telefone, email, senha);
    }

    @Override
    public String toString() {
        return "AdiministradorModelo [" + super.toString() + "]";
    }
    

    

}
