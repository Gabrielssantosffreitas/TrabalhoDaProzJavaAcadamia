package org.gabriel.telas.adiministrador;

import org.gabriel.modelos.AdiministradorModelo;
import org.gabriel.modelos.AlunoModelo;
import org.gabriel.repositorio.AdiministradorCRUDRepositorio;
import org.gabriel.repositorio.AlunoCRUDRepositorio;
import org.gabriel.servicos.CadastraAdiministradorServico;
import org.gabriel.servicos.CadastrarAlunoService;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class CadastrarAlunoParaAdiministradorTela {
    private  static AlunoCRUDRepositorio alunoCRUDRepositorio =  new AlunoCRUDRepositorio();
    private  static CadastrarAlunoService cadastrarAlunoService =  new CadastrarAlunoService(alunoCRUDRepositorio);

    public  static void  exibir(Scanner s) throws InterruptedException, NoSuchAlgorithmException {
        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("=============== Cadastrar Aluno =============== ");
        ColoresUtil.printBlue("Digite o Nome ");
        var nome = s.nextLine();
        ColoresUtil.printCyan("Digite o email ");
        ColoresUtil.printPurple("Regra Do email: exemplo@exemplo.ex");
        var email = s.nextLine();
        ColoresUtil.printBlue("Digite o telefone ");
        ColoresUtil.printPurple("Regra Do telefone: XXXXXXXXXX");
        var telefone = s.nextLine();
        ColoresUtil.printCyan("Digite o cpf ");
        ColoresUtil.printPurple("Regra Do cpf: zzzxxxzzzxx");
        var cpf = s.nextLine();
        ColoresUtil.printCyan("Digite o senha ");
        ColoresUtil.printPurple("Regra Da senha: pelo menos 1 letra maiuscula; pelo menos 1 numero pelo menos 1 uma letra minuscula pelo menos 1 caracter especial no minimo 8 digitos");
        var senha = s.nextLine();

        cadastrarAlunoService.cadastrarAluno(new AlunoModelo(nome,cpf,telefone,email,senha));
    }
}
