import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class Main {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        Gson gson = new Gson();
        LocalDate localDate = LocalDate.now();
        long count = 0;
        List <Actives> listOfActives = new ArrayList<>();
        List<Company> listOfCompanies = gson.fromJson(new FileReader("File.json"), new TypeToken<List<Company>>(){}.getType());

        //1 задание
        listOfCompanies.forEach(l -> System.out.println(l.name + " - Дата основания " +
                                l.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        System.out.println("------------------------------------");

        //заполнение листа бумаг и владельцев
        listOfCompanies.forEach(l -> l.actives.forEach(a -> {
            a.nameOfOwner = l.name;
            listOfActives.add(a);
            }));

        //задание 2
        listOfActives.stream()
                .filter(l -> l.date.isBefore(localDate))
                .forEach(System.out::println);

        count = listOfActives.stream()
                .filter(l -> l.date.isBefore(localDate))
                .count();
        System.out.println("Count of actives: " + count);
        System.out.println("------------------------------------");

        //Задание 3
        companyCreateAfterDate(listOfCompanies);
        System.out.println("------------------------------------");

        //4 задание
        printActives(listOfActives);

    }


    public static void companyCreateAfterDate(List<Company> list) throws IOException {
        Pattern dateMask = Pattern.compile("^\\d{2}[\\.\\/]\\d{2}[\\.\\,\\/](\\d{4}|\\d{2})$");
        Scanner scanner = new Scanner(System.in);
        LocalDate localDate = LocalDate.now();
        System.out.println("Введите дату создания компании");
        String date = scanner.nextLine();
        Matcher matcher = dateMask.matcher(date);
        if (matcher.find()) {
            String[] str = date.split("\\.|,|/");
            int[] ints = new int[3];
            for (int i = 0; i < 3; i++) {
                ints[i] = Integer.parseInt(str[i]);
            }
            if (ints[2] < 100) {
                if (ints[2] > (localDate.getYear() - 2000)) {
                    ints[2] += 1900;
                } else {
                    ints[2] += 2000;
                }
            }
            LocalDate dateOfCreate = LocalDate.of(ints[2], ints[1], ints[0]);
            list.forEach(l -> {
                if (l.date.isAfter(dateOfCreate)) {
                    System.out.println(l.name + " - Дата основания " +
                            l.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
            });
        }else {
            System.out.println("Неверный формат даты");
            throw new IOException();
        }
    }

    public static void printActives(List<Actives> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите валюту: ");
        String userValute = scanner.nextLine();

        try {
            Valutes valute = Valutes.valueOf(userValute.toUpperCase());
            list.stream()
                    .filter((l) -> l.valute.equals(valute))
                    .forEach(System.out::println);
        }catch (IllegalArgumentException e) {
            System.out.println("Не верная валюта");
        }catch (NullPointerException e) {
            System.out.println("Передана пустая строка");
        }

        scanner.close();
    }




}
