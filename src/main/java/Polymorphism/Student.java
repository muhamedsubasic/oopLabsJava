package Polymorphism;

public class Student extends UniversityPerson{
    private String studentId;
    private String major;

    public Student(String name, int birthYear, String studentId, String major){
        super(name, birthYear);
        this.studentId = studentId;
        this.major = major;
    }

    @Override
    public String getRole(){ return "Student"; }

    public String getStudentInfo(){ return this.name + " studies " + this.major; }
}
