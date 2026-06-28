package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.execoe.ValorInvalidoExecaoExecao;
import org.gabriel.modelos.AdiministradorModelo;
import org.gabriel.repositorio.AdiministradorCRUDRepositorio;
import org.gabriel.servicos.utilidades.HashUtil;
import org.gabriel.servicos.utilidades.RegexUtil;

import java.security.NoSuchAlgorithmException;

@AllArgsConstructor
public class CadastraAdiministradorServico {
    AdiministradorCRUDRepositorio adiministradorCRUDRepositorio;


    private void cadastrarAdministradorVarificador (AdiministradorModelo adiministradorModelo){
        if (!RegexUtil.eEmail(adiministradorModelo.getEmail())){ throw  new ValorInvalidoExecaoExecao("Esse email nao segue as regras");}
        if (!RegexUtil.eTelefone(adiministradorModelo.getTelefone())){ throw  new ValorInvalidoExecaoExecao("Seu telenofe nao segue as  regras");}
        if (!RegexUtil.eSenhaForte(adiministradorModelo.getSenha())){ throw  new ValorInvalidoExecaoExecao("Sua senha nao segue as  regras");}
        if (!RegexUtil.eCpf(adiministradorModelo.getCpf())){ throw  new ValorInvalidoExecaoExecao("Seu Cpf nao segue as  regras");}
    }
    public void cadastrarAdiministrador(AdiministradorModelo adiministradorModelo) throws NoSuchAlgorithmException {
        this.cadastrarAdministradorVarificador(adiministradorModelo);
        adiministradorModelo.setSenha(HashUtil.gerarHash(adiministradorModelo.getSenha()));
        adiministradorCRUDRepositorio.criar(adiministradorModelo);
    }
}
