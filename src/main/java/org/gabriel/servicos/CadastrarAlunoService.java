package org.gabriel.servicos;

import lombok.AllArgsConstructor;
import org.gabriel.execoe.ValorInvalidoExecaoExecao;
import org.gabriel.modelos.AdiministradorModelo;
import org.gabriel.modelos.AlunoModelo;
import org.gabriel.repositorio.AdiministradorCRUDRepositorio;
import org.gabriel.repositorio.AlunoCRUDRepositorio;
import org.gabriel.servicos.utilidades.HashUtil;
import org.gabriel.servicos.utilidades.RegexUtil;

import java.security.NoSuchAlgorithmException;

@AllArgsConstructor
public class CadastrarAlunoService {

        private  AlunoCRUDRepositorio alunoCRUDRepositorio;



        private void cadastrarAlunoVarificador (AlunoModelo alunoModelo){
            if (!RegexUtil.eEmail(alunoModelo.getEmail())){ throw  new ValorInvalidoExecaoExecao("Esse email nao segue as regras");}
            if (!RegexUtil.eTelefone(alunoModelo.getTelefone())){ throw  new ValorInvalidoExecaoExecao("Seu telenofe nao segue as  regras");}
            if (!RegexUtil.eSenhaForte(alunoModelo.getSenha())){ throw  new ValorInvalidoExecaoExecao("Sua senha nao segue as  regras");}
            if (!RegexUtil.eCpf(alunoModelo.getCpf())){ throw  new ValorInvalidoExecaoExecao("Seu Cpf nao segue as  regras");}
        }
        public void cadastrarAluno(AlunoModelo alunoModelo) throws NoSuchAlgorithmException {
            this.cadastrarAlunoVarificador(alunoModelo);
            alunoModelo.setSenha(HashUtil.gerarHash(alunoModelo.getSenha()));
            alunoCRUDRepositorio.criar(alunoModelo);
        }
}
