package com.example.miroboadvisor1_0;

import java.math.BigInteger;

public class Validaciones {

    public static boolean validarIBAN(String cuenta) {

        boolean esValido = false;
        int i = 2;
        int caracterASCII = 0;
        int resto = 0;
        int dc = 0;
        String cadenaDc = "";
        BigInteger cuentaNumero = new BigInteger("0");
        BigInteger modo = new BigInteger("97");

        if(cuenta.length() == 24 && cuenta.substring(0,1).toUpperCase().equals("E")
                && cuenta.substring(1,2).toUpperCase().equals("S")) {
            do {
                caracterASCII = cuenta.codePointAt(i);
                esValido = (caracterASCII > 47 && caracterASCII < 58);
                i++;
            }
            while(i < cuenta.length() && esValido);

            if(esValido) {
                cuentaNumero = new BigInteger(cuenta.substring(4,24) + "142800");
                resto = cuentaNumero.mod(modo).intValue();
                dc = 98 - resto;
                cadenaDc = String.valueOf(dc);
            }
            if(dc < 10) {
                cadenaDc = "0" + cadenaDc;
            }
            // Comparamos los caracteres 2 y 3 de la cuenta (dígito de control IBAN) con cadenaDc
            if(cuenta.substring(2,4).equals(cadenaDc)) {
                esValido = true;
            } else {
                esValido = false;
            }
        }
        return esValido;
    }

    public static boolean validarNIE(String nie) {

        boolean esValido = false;
        int i = 1;
        int caracterASCII = 0;
        char letra = ' ';
        int miNIE = 0;
        int resto = 0;
        char[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B',
                'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        if(nie.length() == 9 && Character.isLetter(nie.charAt(8))
                && (Character.toUpperCase(nie.charAt(0)) == 'X'
                ||  Character.toUpperCase(nie.charAt(0)) == 'Y'
                ||	Character.toUpperCase(nie.charAt(0)) == 'Z')) {

            do {
                caracterASCII = nie.codePointAt(i);
                esValido = (caracterASCII > 47 && caracterASCII < 58);
                i++;
            } while(i < nie.length() - 1 && esValido);
        }
        if(esValido && nie.substring(0,1).toUpperCase().equals("X")) {
            nie = "0" + nie.substring(1,9);
        } else if(esValido && nie.substring(0,1).toUpperCase().equals("Y")) {
            nie = "1" + nie.substring(1,9);
        } else if(esValido && nie.substring(0,1).toUpperCase().equals("Z")) {
            nie = "2" + nie.substring(1,9);
        }
        if(esValido) {
            letra = Character.toUpperCase(nie.charAt(8));
            miNIE = Integer.parseInt(nie.substring(1,8));
            resto = miNIE % 23;
            esValido = (letra == asignacionLetra[resto]);
        }
        return esValido;
    }

    public static boolean validarDNI(String dni) {

        boolean esValido = false;
        int i = 0;
        int caracterASCII = 0;
        char letra = ' ';
        int miDNI = 0;
        int resto = 0;
        char[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        if(dni.length() == 9 && Character.isLetter(dni.charAt(8))) {
            do {
                caracterASCII = dni.codePointAt(i);
                esValido = (caracterASCII > 47 && caracterASCII < 58);
                i++;
            }
            while(i < dni.length() - 1 && esValido);
        }
        if(esValido) {
            letra = Character.toUpperCase(dni.charAt(8));
            miDNI = Integer.parseInt(dni.substring(0,8));
            resto = miDNI % 23;
            esValido = (letra == asignacionLetra[resto]);
        }
        return esValido;
    }
}
