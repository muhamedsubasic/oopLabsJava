package Inheritance;

public class Student extends Person{
    private String studentId;
    private String major;

    public Student(String email, String name, int birthYear, String studentId, String major){
        super(email, name, birthYear);
        this.studentId = studentId;
        this.major = major;
    }

    public String getStudentId(){ return this.studentId; }
    public void setStudentId(String studentId){ this.studentId = studentId; }
    public String getMajor(){ return this.major; }
    public void setMajor(String major){ this.major = major; }

    @Override
    public String getInfo(int currentYear){
        return super.getInfo(currentYear) + " StudentId: " + this.studentId + " Major: " + this.major;
    }
}
