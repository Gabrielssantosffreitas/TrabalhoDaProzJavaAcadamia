package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.execoe.CpfouSenhaErradoExecao;
import org.gabriel.repositorio.AlunoCRUDRepositorio;
import org.gabriel.servicos.utilidades.HashUtil;

import java.security.NoSuchAlgorithmException;

@AllArgsConstructor
public class LoginAlunoServicos {
    private AlunoCRUDRepositorio alunoCRUDRepositorio;

    public void Logar(String cpf, String senha) throws NoSuchAlgorithmException {
        var alunoLogin = alunoCRUDRepositorio.selecionarPorCpf(cpf);

        if (!alunoLogin.getSenha().equals(HashUtil.gerarHash(senha))) {
            throw new CpfouSenhaErradoExecao("Cpf ou Senhas estao errados ");
        }
    }
}
