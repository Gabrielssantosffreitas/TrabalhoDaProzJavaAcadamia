package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.execoe.CpfouSenhaErradoExecao;
import org.gabriel.repositorio.ProfessorCRUDRepositorio;
import org.gabriel.servicos.utilidades.HashUtil;

import java.security.NoSuchAlgorithmException;

@AllArgsConstructor
public class LoginProfessorServicos {
    private ProfessorCRUDRepositorio professorCRUDRepositorio;

    public void Logar(String cpf, String senha) throws NoSuchAlgorithmException {
        var professorLogin = professorCRUDRepositorio.selecionarPorCpf(cpf);

        if (!professorLogin.getSenha().equals(HashUtil.gerarHash(senha))) {
            throw new CpfouSenhaErradoExecao("Cpf ou Senhas estao errados ");
        }
    }
}
