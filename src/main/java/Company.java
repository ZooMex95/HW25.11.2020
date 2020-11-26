public class Company {
    public String name;
    public String address;
    public int telephone;
    public int inn;
    public int ogrn;
    public Actives actives;

    public Company(String name, String address, int telephone, int inn, int ogrn, Actives actives) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.inn = inn;
        this.ogrn = ogrn;
        this.actives = actives;
    }

    @Override
    public String toString() {
        return "Название: " + this.name + "\n" +
                "адрес: " + this.address + "\n" +
                "телефон: " + this.telephone + "\n" +
                "ИНН: " + this.inn + "\n" +
                "ОГРН: " + this.ogrn + "\n" +
                "Ценные бумаги: " + this.actives + "\n" +
                "-----------------------------------------";
    }
}
