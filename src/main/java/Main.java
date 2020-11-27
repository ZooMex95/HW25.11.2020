import java.io.FileNotFoundException;
import java.io.FileReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        List <Actives> listOfActives = new ArrayList<>();
        List<Company> listOfCompanies = gson.fromJson(new FileReader("File.json"), new TypeToken<List<Company>>(){}.getType());


        listOfCompanies.forEach(l -> System.out.println(l.name + " - Дата основания " +             //1 задание
                                l.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        System.out.println("------------------------------------");


        listOfCompanies.forEach(l -> l.actives.forEach(a -> {
            a.nameOfOwner = l.name;
            listOfActives.add(a);       //заполнение листа бумаг и владельцев
            }));

        activesAfterDate(listOfActives); //задание 2
        System.out.println("------------------------------------");

        companyCreateAfterDate(listOfCompanies); //задание 3
        System.out.println("------------------------------------");

        printActives(listOfActives);




    }

    public static void activesAfterDate(List<Actives> listOfActives) {
        LocalDate localDate = LocalDate.now();
        int count = 0;
        for (Actives actives: listOfActives
             ) {
            if (actives.date.isBefore(localDate)) {
                System.out.println(actives.nameOfOwner + actives);      //2 задание
                count++;
            }
        }
        System.out.println("Count of actives: " + count);
    }

    public static void companyCreateAfterDate(List<Company> list) {
        Scanner scanner = new Scanner(System.in);
        LocalDate localDate = LocalDate.now();
        System.out.println("Введите дату создания компании");
        String date = scanner.nextLine();
        String[] str = date.split("\\.|,|/");
        int[] ints = new int[3];
        for (int i = 0; i <3; i++){
            ints[i] = Integer.parseInt(str[i]);
        }
        if(ints[2] < 100){
            if (ints[2] > (localDate.getYear() - 2000)) {
                ints[2]+=1900;
            }
            else {
                ints[2]+=2000;
            }
        }
        LocalDate dateOfCreate = LocalDate.of(ints[2],ints[1],ints[0]);
        list.forEach(l -> {
            if (l.date.isAfter(dateOfCreate)) {
                System.out.println(l.name + " - Дата основания " +
                        l.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        });

    }

    public static void printActives(List<Actives> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите валюту: ");
        String valute = scanner.nextLine();
        list.forEach(l -> {
            if (l.valute.toString().equals(valute)) {
                System.out.println("Название: " + l.name + "  код: " + l.code);
            }
        });

        scanner.close();
    }




}
