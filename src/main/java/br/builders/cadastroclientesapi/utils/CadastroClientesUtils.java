package br.builders.cadastroclientesapi.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;

public class CadastroClientesUtils {



    public Calendar getCalendar() {
        Calendar c = Calendar.getInstance();
        return  c;
    }


    public static int getAnoAtual() {

        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int anoAtual = c.get(Calendar.YEAR);
        return anoAtual;

    }

    public static int getDiferencaEntreAnos(Date param) {

        Calendar c = Calendar.getInstance();
        c.setTime(param);
        int anoParam = c.get(Calendar.YEAR);
        return  getAnoAtual() - anoParam;

    }



    public  static  String generatedString(int tamanho, boolean letras, boolean numeros) {

        String generatedString = RandomStringUtils.random(tamanho, letras, numeros);

        return generatedString;
    }



    public static  int generatedInt(){


        SecureRandom secureRandom = new SecureRandom();

        return secureRandom.nextInt();
    }



}
