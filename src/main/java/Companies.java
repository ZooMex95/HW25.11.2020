public abstract class Companies {
    public String name;
    public String address;
    public String telephone;
    public String inn;
    public String ogrn;
    public Actives actives;

    public Companies(String name, String address, String telephone, String inn, String ogrn, Actives actives) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.inn = inn;
        this.ogrn = ogrn;
        this.actives = actives;
    }
}
