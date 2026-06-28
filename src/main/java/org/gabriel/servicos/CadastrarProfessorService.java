package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.execoe.ValorInvalidoExecaoExecao;
import org.gabriel.modelos.ProfessorModelo;
import org.gabriel.repositorio.ProfessorCRUDRepositorio;
import org.gabriel.servicos.utilidades.HashUtil;
import org.gabriel.servicos.utilidades.RegexUtil;

import java.security.NoSuchAlgorithmException;

@AllArgsConstructor
public class CadastrarProfessorService {
    private ProfessorCRUDRepositorio professorCRUDRepositorio;

    private void cadastrarProfessorVarificador(ProfessorModelo professorModelo) {
        if (!RegexUtil.eEmail(professorModelo.getEmail())) {
            throw new ValorInvalidoExecaoExecao("Esse email nao segue as regras");
        }
        if (!RegexUtil.eTelefone(professorModelo.getTelefone())) {
            throw new ValorInvalidoExecaoExecao("Seu telefone nao segue as regras");
        }
        if (!RegexUtil.eSenhaForte(professorModelo.getSenha())) {
            throw new ValorInvalidoExecaoExecao("Sua senha nao segue as regras");
        }
        if (!RegexUtil.eCpf(professorModelo.getCpf())) {
            throw new ValorInvalidoExecaoExecao("Seu CPF nao segue as regras");
        }
    }

    public void cadastrarProfessor(ProfessorModelo professorModelo) throws NoSuchAlgorithmException {
        this.cadastrarProfessorVarificador(professorModelo);
        professorModelo.setSenha(HashUtil.gerarHash(professorModelo.getSenha()));
        professorCRUDRepositorio.criar(professorModelo);
    }
}
