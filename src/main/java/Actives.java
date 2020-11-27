import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Actives {
    public String code;
    public LocalDate date;
    public String name;
    public Valutes valute;
    public String nameOfOwner;

/*    public Actives(String code, String date, String name, Valutes valutes) {
        this.code = code;
        this.date = date;
        this.name = name;
        this.valute = valutes;
    }*/

    @Override
    public String toString() {
        return "\n" + "  Название: " + name + "\n" + "  Срок действия до: " + date.format(DateTimeFormatter.ofPattern("dd.MM.uuuu"))
                + "\n" + "  Код: " + code + "\n" + "  Валюта: " + valute + "\n" + "  --------------";
    }
}
