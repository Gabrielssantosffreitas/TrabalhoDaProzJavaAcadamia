package org.gabriel.modelos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public  class PessoaModelo {
    @Getter
    private  String nome;
    @Getter
    private  String cpf;
    @Getter @Setter
    private  String telefone;
    @Setter @Getter
    private  String email;
    @Setter @Getter
    private  String senha;
}
