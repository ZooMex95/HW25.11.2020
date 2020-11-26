public class Company extends Companies {

    public Company(String name, String address, String telephone, String inn, String ogrn, Actives actives) {
        super(name, address, telephone, inn, ogrn, actives);
    }

    @Override
    public String toString() {
        return "Название: " + super.name + "\n" +
                "адрес: " + super.address + "\n" +
                "телефон: " + super.telephone + "\n" +
                "ИНН: " + super.inn + "\n" +
                "ОГРН: " + super.ogrn + "\n" +
                "Ценные бумаги: " + super.actives + "\n" +
                "-----------------------------------------";
    }
}
