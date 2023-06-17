package sum.general;

import sum.person.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
    public enum Role {
        NONE, CLIENT, SERVICE, MANAGER, STOREKEEPER
    }
    public Person person;
    public String login;
    public String password;
    public List<Role> roles;
    public String getName() {
        return login;
    }

    public Account(Person person, String login, String password) {
        this.person = person;
        this.login = login;
        this.password = password;
        roles = new ArrayList<>();
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void addRole(Role newRole) {
        roles.add(newRole);
    }
}
