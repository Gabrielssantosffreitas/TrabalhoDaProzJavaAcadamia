package org.gabriel.telas.utilidades;

public class ClearUtil {
    public  static void LimparTerminal(long time) throws InterruptedException {
        Thread.sleep(time);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
