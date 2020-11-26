import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Company> listOfCompanies = new ArrayList<>();
        //Actives actives = new Actives("123","2020","lkn",Valutes.RUB);
        //Company company = new Company("luk", "msc", "111", "222", "333",
                                        //actives);
        //System.out.println(company);

        Gson gson = new Gson();

        List<Company> list = gson.fromJson(new FileReader("File.json"), new TypeToken<List<Company>>(){}.getType());
        for (Company company:list
             ) {
            System.out.println(company);
        }


/*        Company company = gson.fromJson(new FileReader("File.json"), Company.class);
        System.out.println(company);*/



    }
}
