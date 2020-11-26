import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Company {
    public String name;
    public String address;
    public int telephone;
    public int inn;
    public int ogrn;
    public LocalDate date;
    public List<Actives> actives;

/*    public Company(String name, String address, int telephone, int inn, int ogrn, String date, Actives actives) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.inn = inn;
        this.ogrn = ogrn;
        this.date = LocalDate.parse(date);
        this.actives.add(actives);
    }*/

    @Override
    public String toString() {
        return "Название: " + this.name + "\n" +
                "адрес: " + this.address + "\n" +
                "телефон: " + this.telephone + "\n" +
                "ИНН: " + this.inn + "\n" +
                "ОГРН: " + this.ogrn + "\n" +
                "Дата основания: " + this.date.format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + "\n" +
                "Ценные бумаги: " + this.actives + "\n" +
                "---------------------------------";
    }
}
