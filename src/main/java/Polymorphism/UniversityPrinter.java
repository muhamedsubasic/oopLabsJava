package Polymorphism;

public class UniversityPrinter {
    public void printPersonDetails(UniversityPerson person, int currentYear){
        System.out.println(person.toString() + person.getRole());
        System.out.println(person.getAge(currentYear));

        if (person instanceof Student){
            Student s = (Student) person;
            System.out.println(s.getStudentInfo());
        } else if (person instanceof Professor){
            Professor p = (Professor) person;
            System.out.println(p.getProfessorInfo());
        } else if (person instanceof Staff){
            Staff st = (Staff) person;
            System.out.println(st.getStaffInfo());
        }
        System.out.println();
    }
}
