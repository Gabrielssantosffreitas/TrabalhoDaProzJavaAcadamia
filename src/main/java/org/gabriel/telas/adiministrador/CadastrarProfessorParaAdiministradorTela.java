package org.gabriel.telas.adiministrador;

import org.gabriel.modelos.ProfessorModelo;
import org.gabriel.repositorio.ProfessorCRUDRepositorio;
import org.gabriel.servicos.CadastrarProfessorService;
import org.gabriel.telas.utilidades.ClearUtil;
import org.gabriel.telas.utilidades.ColoresUtil;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class CadastrarProfessorParaAdiministradorTela {
    private static ProfessorCRUDRepositorio professorCRUDRepositorio = new ProfessorCRUDRepositorio();
    private static CadastrarProfessorService cadastrarProfessorService = new CadastrarProfessorService(professorCRUDRepositorio);

    public static void exibir(Scanner s) throws InterruptedException, NoSuchAlgorithmException {
        ClearUtil.LimparTerminal(0);
        ColoresUtil.printYellow("=============== Cadastrar Professor =============== ");
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
        ColoresUtil.printCyan("Digite a senha ");
        ColoresUtil.printPurple("Regra Da senha: pelo menos 1 letra maiuscula; pelo menos 1 numero pelo menos 1 uma letra minuscula pelo menos 1 caracter especial no minimo 8 digitos");
        var senha = s.nextLine();

        cadastrarProfessorService.cadastrarProfessor(new ProfessorModelo(nome, cpf, telefone, email, senha));
    }
}
