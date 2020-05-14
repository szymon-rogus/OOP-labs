package pl.edu.agh.to.lab4.model;

public class Person extends Suspect {

    public Person(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public boolean canBeSuspect() {
        return getAge() > 18;
    }

}
