package pl.edu.agh.to.lab4.model;

import java.util.Calendar;

public class Prisoner extends Suspect {
    private final int judgementYear;
    private final int sentenceTime;
    private final String pesel;

    public Prisoner(String name, String surname, String pesel, int age,  int judgementYear, int sentenceTime) {
        super(name, surname, age);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceTime = sentenceTime;
    }

    public String getPesel() {
        return pesel;
    }

    public boolean isJailedNow() {
        return judgementYear + sentenceTime >= getCurrentYear();
    }

    private int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    @Override
    public boolean canBeSuspect() {
        return !isJailedNow();
    }
}
