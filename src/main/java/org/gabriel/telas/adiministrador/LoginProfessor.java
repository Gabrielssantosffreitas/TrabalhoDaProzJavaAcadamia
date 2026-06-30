package org.gabriel.telas.adiministrador;

import org.gabriel.repositorio.ProfessorCRUDRepositorio;
import org.gabriel.servicos.LoginProfessorServicos;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.util.Scanner;

public class LoginProfessor {
    private static ProfessorCRUDRepositorio professorCRUDRepositorio = new ProfessorCRUDRepositorio();
    private static LoginProfessorServicos loginProfessorServicos = new LoginProfessorServicos(professorCRUDRepositorio);

    public static void exibir(Scanner s) throws InterruptedException {
        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("===========Login Professor ===========");
        s.nextLine();

        ColoresUtil.printBlue("digite seu Cpf");
        var cpf = s.nextLine();
        ColoresUtil.printCyan("digite sua senha:");
        var senha = s.nextLine();

        try {
            loginProfessorServicos.Logar(cpf, senha);
            ClearUtil.LimparTerminal(0);

            AcessoProfessorTela.exibir(s);
        } catch (Exception e) {
            ColoresUtil.printRed(e.getMessage() + "/n" + e.getCause());
        }
    }
}
