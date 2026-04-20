package Polymorphism;

public class UniversityPerson {
    String name;
    private int birthYear;

    public UniversityPerson(String name, int birthYear){
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getRole(){ return "University Person"; }
    public int getAge(int currentYear){ return currentYear - this.birthYear; }

    @Override
    public String toString(){ return this.name + " (born " + this.birthYear + " )"; }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UniversityPerson u = (UniversityPerson) object;
        return birthYear == u.birthYear && name.equals(u.name);
    }
}
