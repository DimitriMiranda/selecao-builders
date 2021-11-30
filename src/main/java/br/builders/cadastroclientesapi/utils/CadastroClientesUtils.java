package br.builders.cadastroclientesapi.utils;

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


//    public static void main(String[] args) {
//
//
//    }


}
