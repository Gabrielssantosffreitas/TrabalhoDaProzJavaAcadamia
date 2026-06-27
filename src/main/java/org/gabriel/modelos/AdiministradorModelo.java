package org.gabriel.modelos;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdiministradorModelo {
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
