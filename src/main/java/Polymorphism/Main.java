package Polymorphism;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== UniversityPerson Demo ===");
        UniversityPrinter printer = new UniversityPrinter();

        Student student = new Student("Alice", 2002, "S123", "Computer Science");
        Professor professor = new Professor("Dr. Brown", 1975, "E456", "Physics");
        Staff staff = new Staff("Charlie", 1985, "ST789", "Librarian");

        printer.printPersonDetails(student, 2026);
        printer.printPersonDetails(professor, 2026);
        printer.printPersonDetails(staff, 2026);

        // Equality test for UniversityPerson
        UniversityPerson p1 = new UniversityPerson("John", 1990);
        UniversityPerson p2 = new UniversityPerson("John", 1990);
        UniversityPerson p3 = new UniversityPerson("Jane", 1990);
        System.out.println("p1 equals p2: " + p1.equals(p2)); // true
        System.out.println("p1 equals p3: " + p1.equals(p3)); // false
        System.out.println();
    }
}
