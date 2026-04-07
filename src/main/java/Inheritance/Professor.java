package Inheritance;

public class Professor extends Person{
    private String employeeId;
    private String department;

    public Professor(String name, String email, int birthYear, String employeeId, String department){
        super(name, email, birthYear);
        this.employeeId = employeeId;
        this.department = department;
    }

    public String getEmployeeId(){ return this.employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getDepartment(){ return this.department; }
    public void setDepartment(String department){ this.department = department; }

    @Override
    public String getInfo(int currentYear){
        return super.getInfo(currentYear) + " EmployeeId: " + this.employeeId + " Department: " + this.department;
    }

}
