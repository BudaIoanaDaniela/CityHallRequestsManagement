package Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CurrentDate {

    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Date date ;


    public  static String getCurrentDate(Date date)
    {
        return sdf.format(date);
    }

}
