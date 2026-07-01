package org.gabriel.servicos.utilidades;

import java.util.regex.Pattern;

public class RegexUtil {
    public static final Pattern email = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    public static final Pattern senha = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
    public static final Pattern cpf = Pattern.compile("^\\d{11}$");
    public static final Pattern telefone = Pattern.compile("^\\d{10,11}$");
    public static final Pattern data = Pattern.compile("^(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}$");

    public static boolean eEmail(String texto) {
        return RegexUtil.email.matcher(texto).matches();
    }

    public static boolean eSenhaForte(String texto) {
        return RegexUtil.senha.matcher(texto).matches();
    }

    public static boolean eCpf(String texto) {
        return RegexUtil.cpf.matcher(texto).matches();
    }

    public static boolean eTelefone(String texto) {
        return RegexUtil.telefone.matcher(texto).matches();
    }

    public static boolean eData(String texto) {
        return RegexUtil.data.matcher(texto).matches();
    }
}
