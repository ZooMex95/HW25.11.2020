public class Actives {
    public String code;
    public String date;
    public String name;
    public Valutes valute;

    public Actives(String code, String date, String name, Valutes valutes) {
        this.code = code;
        this.date = date;
        this.name = name;
        this.valute = valutes;
    }

    @Override
    public String toString() {
        return "\n" + "  Код: " + code + "\n" + "  Срок действия до: " + date + "\n"
                + "  Название: " + name + "\n" + "  Валюта: " + valute;
    }
}
