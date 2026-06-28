package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.execoe.CpfouSenhaErradoExecao;
import org.gabriel.repositorio.AdiministradorCRUDRepositorio;
import org.gabriel.servicos.utilidades.HashUtil;

import java.security.NoSuchAlgorithmException;

@AllArgsConstructor
public class LoginAdiministradorServicos {
    private AdiministradorCRUDRepositorio adiministradorCRUDRepositorio;

    public void Logar(String cpf, String senha) throws NoSuchAlgorithmException {
        var adimistradorLogin = adiministradorCRUDRepositorio.selecionarPorCpf(cpf);

        if(!adimistradorLogin.getSenha().equals(HashUtil.gerarHash(senha))){
            throw new CpfouSenhaErradoExecao("Cpf ou Senhas estao errados ");
        }


    }
}
