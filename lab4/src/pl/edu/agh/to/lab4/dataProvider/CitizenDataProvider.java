package pl.edu.agh.to.lab4.dataProvider;

import pl.edu.agh.to.lab4.model.Person;

import java.util.ArrayList;
import java.util.Collection;

public class CitizenDataProvider {

    private final Collection<Person> cracovCitizens = new ArrayList<Person>();

    public CitizenDataProvider() {
    }
    public void addExampleData(){
        addCitizen(new Person("Jan", "Kowalski", 30));
        addCitizen(new Person("Janusz", "Krakowski", 30));
        addCitizen(new Person("Janusz", "Mlodociany", 10));
        addCitizen(new Person("Kasia", "Kosinska", 19));
        addCitizen(new Person("Piotr", "Zgredek", 29));
        addCitizen(new Person("Tomek", "Gimbus", 14));
        addCitizen(new Person("Janusz", "Gimbus", 15));
        addCitizen(new Person("Alicja", "Zaczarowana", 22));
        addCitizen(new Person("Janusz", "Programista", 77));
        addCitizen(new Person("Pawel", "Pawlowicz", 32));
        addCitizen(new Person("Krzysztof", "Mendel", 30));

    }
    public void addCitizen(Person newCitizen){
        cracovCitizens.add(newCitizen);
    }
    public Collection<Person> getCitizens() {
        return cracovCitizens;
    }
}
