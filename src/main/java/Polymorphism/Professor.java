package Polymorphism;

public class Professor extends UniversityPerson{
    private String employeeId;
    private String department;

    public Professor(String name, int birthYear, String employeeId, String department){
        super(name, birthYear);
        this.employeeId = employeeId;
        this.department = department;
    }

    @Override
    public String getRole(){ return "Professor"; }

    public String getProfessorInfo() { return "Prof. " + this.name + " teaches in " + this.department; }
}
