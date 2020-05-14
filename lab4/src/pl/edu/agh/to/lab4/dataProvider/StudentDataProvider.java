package pl.edu.agh.to.lab4.dataProvider;

import pl.edu.agh.to.lab4.model.Student;

import java.util.ArrayList;
import java.util.Collection;

public class StudentDataProvider {

    private final Collection<Student> cracovStudents = new ArrayList<Student>();

    public StudentDataProvider() {
    }

    public void addExampleData(){
        addStudent(new Student("Jan", "Pijus", 22, "295549"));
        addStudent(new Student("Janusz", "Nieodpowiedni", 24, "242901"));
        addStudent(new Student("Joanna", "Alkusek", 21, "245999"));
        addStudent(new Student("Anna", "Wszechwiedząca", 19, "290909"));
        addStudent(new Student("Sebastian", "Abstynent", 20, "288945"));
    }

    public void addStudent(Student newStudent) {
        cracovStudents.add(newStudent);
    }

    public Collection<Student> getStudents() {
        return cracovStudents;
    }
}
