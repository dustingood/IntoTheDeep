import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileIOTest {

    private static FileReader in;
    private static FileWriter out;
    public static void main(String[] args) throws IOException{

        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String todayString = formatter.format(today);

        try {
            in = new FileReader("dates.txt");

            String dateString = "";

            int c;
            while ((c = in.read()) != -1) {
                dateString += (char) c;
            }

            if (todayString.equals(dateString)){
                System.out.println("Program Already Ran Today");
            }
            else{
                System.out.println("First Time Running Today");
            }

            out = new FileWriter("dates.txt");
            out.write(formatter.format(today));

        }
        finally {
            in.close();
            out.close();
        }

    }
}
