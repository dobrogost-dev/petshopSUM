package sum.person;

import sum.person.Employee;

import java.math.BigDecimal;

public class ServiceEmployee extends Employee {

    public ServiceEmployee(int id, String firstName, String lastName, int age, String phone, BigDecimal salary, boolean bonus) {
        super(id, firstName, lastName, age, phone, salary, bonus);
    }
}
