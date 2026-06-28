package org.gabriel.modelos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public  class PessoaModelo {
    @Getter
    protected   String nome;
    @Getter
    protected   String cpf;
    @Getter @Setter
    protected   String telefone;
    @Setter @Getter
    protected   String email;
    @Setter @Getter
    protected   String senha;
}
