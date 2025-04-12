/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.jylc.hilos.Runnable;

/**
 *
 * @author josue
 */

enum NUMERO {
    UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5),
    SEIS(6), SIETE(7), OCHO(8), NUEVE(9), DIEZ(10);

    private final int valor;

    NUMERO(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}

enum LETRA {
    A('A'), B('B'), C('C'), D('D'), E('E'), F('F'), G('G'),
    H('H'), I('I'), J('J'), K('K'), L('L'), M('M'), N('N'),
    O('O'), P('P'), Q('Q'), R('R'), S('S'), T('T'), U('U'),
    V('V'), W('W'), X('X'), Y('Y'), Z('Z');

    private final char letra;

    LETRA(char letra) {
        this.letra = letra;
    }

    public char getLetra() {
        return letra;
    }
}

enum Tipo {
    NUMERO, LETRA
}

public class AlfanumericoTarea implements Runnable {
    private Tipo tipo;

    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        imprimir(tipo); 
    }

    public static synchronized void imprimir(Tipo tipo) {
        if (tipo == Tipo.NUMERO) {
            for (int i = 0; i < NUMERO.values().length - 1; i++) {
                NUMERO n = NUMERO.values()[i];
                System.out.println(Thread.currentThread().getName() +  n  + "  = " + n.getValor());
            }
        } else if (tipo == Tipo.LETRA) {
            for (LETRA l : LETRA.values()) {
                System.out.println(Thread.currentThread().getName() + l + "  = " + l.getLetra());
            }
        }
    }

    public static void main(String[] args) {
        Thread hilo1 = new Thread(new AlfanumericoTarea(Tipo.NUMERO), "Hilo 1");
        Thread hilo2 = new Thread(new AlfanumericoTarea(Tipo.LETRA), "Hiloc 2");
        Thread hilo3 = new Thread(new AlfanumericoTarea(Tipo.NUMERO), "Hilo 3");
        Thread hilo4 = new Thread(new AlfanumericoTarea(Tipo.LETRA), "Hilo 4");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}

