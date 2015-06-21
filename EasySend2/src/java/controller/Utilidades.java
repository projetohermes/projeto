package controller;

// Classe destinadas para m�todos que s�o usados frequentemente no sistema
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

    // M�todo que retorna a data do dia
    public static String getData() {

        Date data = new Date(); //Trazendo a data no estilo padr�o
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy"); //Formatando o estilo da data
        String datas = dataFormatada.format(data); // Data formatada no estilo escolhido

        return datas; // Retornando a data

    }

    public static String getHora() {

        Date date = new Date();

        SimpleDateFormat formatando = new SimpleDateFormat("HH:mm");

        String datas = formatando.format(date);
        
        return datas;

    }
}
