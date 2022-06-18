package ekomp.Models;

public class Person extends ObjectPlusPlus {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void createAccount() {}

    public void login() {}

    public void checkPassword() {}
}
