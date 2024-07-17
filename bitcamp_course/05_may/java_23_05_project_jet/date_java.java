package java_23_05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class date_java {

    public static void main(String[] args) throws ParseException { // add throws ParseException

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // formato data


        Date date1 = new Date(); // data attuale
        System.out.println(date1);


        String dataString = "2021-01-01";
        
        Date date2 = sdf.parse(dataString); // converte la stringa in data

        System.out.println("date2 : " + sdf.format(date2)); // format per convertire la data in stringa


        if (date1.after(date2)) {
            System.out.println("Date1 is after Date2");
        }
        if (date1.before(date2)) {
            System.out.println("Date1 is before Date2");
        }
        if (date1.equals(date2)) {
            System.out.println("Date1 is equal Date2");
        }

        Date dataAttuale = new Date();




    }
    
}
