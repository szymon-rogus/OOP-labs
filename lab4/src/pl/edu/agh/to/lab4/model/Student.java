package pl.edu.agh.to.lab4.model;

public class Student extends Suspect {

    private String index;

    public Student(String name, String surname, int age, String index) {
        super(name, surname, age);
        this.index = index;
    }


    @Override
    public boolean canBeSuspect() {
        return true;
    }
}
