package sum.person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ManagerEmployee extends ServiceEmployee {
    List<Employee> employees;

    public ManagerEmployee(int id, String firstName, String lastName, int age, String phone, BigDecimal salary, boolean bonus) {
        super(id, firstName, lastName, age, phone, salary, bonus);
        employees = new ArrayList<>();
    }
}
