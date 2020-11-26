import java.io.FileNotFoundException;
import java.io.FileReader;

import java.time.format.DateTimeFormatter;
import java.util.List;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        List<Company> listOfCompanies = gson.fromJson(new FileReader("File.json"), new TypeToken<List<Company>>(){}.getType());
/*        for (Company company:listOfCompanies
             ) {
            System.out.println(company);
        }*/
        listOfCompanies.forEach(l -> System.out.println(l.name + " - Дата основания " +
                                l.date.format(DateTimeFormatter.ofPattern("dd/MM/uuuu"))));

        

    }




}
