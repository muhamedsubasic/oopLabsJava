package GenericsTemplateProgramming;

import java.util.List;

public class ReportService {
    public void exportAsGenericReport(List<?> reportList){
        for (Object element : reportList){
            System.out.println(element);
        }
    }
}

class ReportTest{
    public static void main(String[] args) {
        ReportService service = new ReportService();

        List<String> customerNames = List.of("Alice", "Bob", "Charlie");
        List<Double> dailyRevenue = List.of(1250.75, 980.25, 1430.60);
        List<Integer> productRatings = List.of(4, 5, 3, 5);

        System.out.println("Customer names: ");
        service.exportAsGenericReport(customerNames);
        System.out.println("\nDaily Revenue: ");
        service.exportAsGenericReport(dailyRevenue);
        System.out.println("\nProducts Ratings: ");
        service.exportAsGenericReport(productRatings);

    }
}
