package org.gabriel.telas.adiministrador;

import org.gabriel.repositorio.AdiministradorCRUDRepositorio;
import org.gabriel.servicos.LoginAdiministradorServicos;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.util.Scanner;

public class LoginAdiministrador {
    private  static AdiministradorCRUDRepositorio adiministradorCRUDRepositorio = new AdiministradorCRUDRepositorio();
    private  static LoginAdiministradorServicos loginAdiministradorServicos = new LoginAdiministradorServicos(adiministradorCRUDRepositorio);
    public static void exibir (Scanner s) throws InterruptedException {
        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("===========Login Adiministrador ===========");
        s.nextLine();

        ColoresUtil.printBlue("digite seu Cpf");
        var cpf = s.nextLine();
        ColoresUtil.printCyan("digite sua senha:");
        var senha = s.nextLine();

        try {
            loginAdiministradorServicos.Logar(cpf,senha);
            ClearUtil.LimparTerminal(0);

            AcessoAdiministradorTela.exibir(s);





        } catch (Exception e) {
            ColoresUtil.printRed(e.getMessage() +"/n"+ e.getCause() );
        }


    }
}
