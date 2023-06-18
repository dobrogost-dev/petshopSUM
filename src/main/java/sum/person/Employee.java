package sum.person;

import java.math.BigDecimal;

public abstract class Employee extends Person{
    public BigDecimal salary;
    public boolean bonus = false;
    public static int bonusValue = 500;

    public Employee(int id, String firstName, String lastName, int age, String phone, BigDecimal salary, boolean bonus) {
        super(id, firstName, lastName, age, phone);
        this.bonus = bonus;
        this.salary = salary;
    }
}
