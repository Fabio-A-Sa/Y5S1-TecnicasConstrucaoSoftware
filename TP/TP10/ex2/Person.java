public class Person {

    @FriendlyName("person name")
    private String name;

    @FriendlyName("person home address")
    private String address;

    @FriendlyName("person telephone number")
    private String phone;

    public Person(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return GenericToString.toString(this);
    }

    public static void main(String[] args) {
        Person person = new Person("Alpino Sempre Empé", "Rua da Cunha Parlamentar, N 96, Coimbra B", "900060009");
        System.out.println(person);
    }
}