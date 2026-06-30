package org.gabriel.telas.aluno;

import org.gabriel.repositorio.AlunoCRUDRepositorio;
import org.gabriel.servicos.LoginAlunoServicos;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.util.Scanner;

public class LoginAluno {
    private static AlunoCRUDRepositorio alunoCRUDRepositorio = new AlunoCRUDRepositorio();
    private static LoginAlunoServicos loginAlunoServicos = new LoginAlunoServicos(alunoCRUDRepositorio);

    public static void exibir(Scanner s) throws InterruptedException {
        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("===========Login Aluno ===========");
        s.nextLine();

        ColoresUtil.printBlue("digite seu Cpf");
        var cpf = s.nextLine();
        ColoresUtil.printCyan("digite sua senha:");
        var senha = s.nextLine();

        try {
            loginAlunoServicos.Logar(cpf, senha);
            ClearUtil.LimparTerminal(0);

            AcessoAlunoTela.exibir(s);
        } catch (Exception e) {
            ColoresUtil.printRed(e.getMessage() + "/n" + e.getCause());
        }
    }
}
