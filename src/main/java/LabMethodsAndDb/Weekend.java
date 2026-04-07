package LabMethodsAndDb;

public class  Weekend {
    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    public static boolean isWeekend(Day day){
        return day == Day.SATURDAY || day == Day.SUNDAY;
    }

    public static void main(String[] args) {
        System.out.println("Monday is a weekend? " + isWeekend(Day.MONDAY));
        System.out.println("Saturday is a weekend? " + isWeekend(Day.SATURDAY));
    }
}
