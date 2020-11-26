import java.util.ArrayList;
import com.google.gson.Gson;


public class Main {

    public static void main(String[] args) {
        ArrayList<Companies> listOfCompanies = new ArrayList<>();
        //Actives actives = new Actives("123","2020","lkn",Valutes.RUB);
        //Company company = new Company("luk", "msc", "111", "222", "333",
                                        //actives);
        //System.out.println(company);

        Gson gson = new Gson();


        Company company = gson.fromJson("H:\\File.json", Company.class);
        System.out.println(company);



    }
}
