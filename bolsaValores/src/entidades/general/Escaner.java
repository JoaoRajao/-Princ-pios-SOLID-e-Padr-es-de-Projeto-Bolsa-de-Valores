package entidades.general;

import entidades.Excecoes.NaoEhUmaCadeiaSemNumeros;
import entidades.Excecoes.NaoEhIdExcepcion;
import entidades.Excecoes.NaoEDoubleExcecao;
import entidades.Excecoes.NaoEInteiroExcecao;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Escaner {
    private Scanner sc;

    public Escaner() {
        this.sc = new Scanner(System.in);
        sc.useDelimiter("\\R");
    }

    public int lerInteiro() throws NaoEInteiroExcecao {
        int inteiro = 0;
        try {
            inteiro = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
            throw new NaoEInteiroExcecao();
        }
        return inteiro;
    }

    public double lerDouble() throws NaoEDoubleExcecao {
        double duplo = 0;
        try {
            duplo = sc.nextDouble();
        } catch (InputMismatchException e) {
            sc.next();
            throw new NaoEDoubleExcecao();
        }
        return duplo;
    }

    public String lerCadeiaSemNumeros() throws NaoEhUmaCadeiaSemNumeros {
        String cadeia;
        cadeia = sc.nextLine();
        try {
            if (!Pattern.matches("[a-zA-Z]+", cadeia)) throw new NaoEhUmaCadeiaSemNumeros();
        } catch (NaoEhUmaCadeiaSemNumeros e) {
            sc.next();
            throw new NaoEhUmaCadeiaSemNumeros();
        }
        return cadeia;
    }

    public String lerId() throws NaoEhIdExcepcion {
        String cadeia;
        cadeia = sc.nextLine();
        try {
            if (!Pattern.matches("[0-9]{8}+[A-Z]", cadeia)) throw new NaoEhIdExcepcion();
        } catch (NaoEhIdExcepcion e) {
            sc.next();
            throw new NaoEhIdExcepcion();
        }
        return cadeia;
    }

    public String lerCadeia() {
        return sc.nextLine();
    }
}
