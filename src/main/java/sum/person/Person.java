package sum.person;

import java.io.Serializable;

public abstract class Person implements Serializable {
    public int id;
    public String firstName;
    public String lastName;
    public int age;
    public String phone;

    public Person(int id, String firstName, String lastName, int age, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }
}
