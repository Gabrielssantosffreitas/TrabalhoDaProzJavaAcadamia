package org.gabriel.servicos.utilidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    public static  String gerarHash(String texto ) throws NoSuchAlgorithmException {
       var messageDigest = MessageDigest.getInstance("SHA-256");
        var resultado = new StringBuilder(); // StringBuilder e Melheror  no caso de manipulacao de String .
        var hash = messageDigest.digest(texto.getBytes());
        for(var b : hash){
            resultado.append(String.format("%02x", b));
        }
        return resultado.toString();
    }
}
