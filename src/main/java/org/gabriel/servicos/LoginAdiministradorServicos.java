package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.execoe.CpfouSenhaErradoExecao;
import org.gabriel.repositorio.AdiministradorCRUDRepositorio;

@AllArgsConstructor
public class LoginAdiministradorServicos {
    private AdiministradorCRUDRepositorio adiministradorCRUDRepositorio;

    public void Logar(String cpf, String senha){
        var adimistradorLogin = adiministradorCRUDRepositorio.selecionarPorCpf(cpf);

        if(!adimistradorLogin.getSenha().equals(senha)){
            throw new CpfouSenhaErradoExecao("Cpf ou Senhas estao errados ");
        }


    }
}
