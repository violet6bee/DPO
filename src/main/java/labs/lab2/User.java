package labs.lab2;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String country;

    public User(int id, String firstName, String lastName, int age, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return lastName + " " + age;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}
