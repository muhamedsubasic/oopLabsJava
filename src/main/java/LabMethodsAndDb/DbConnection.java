package LabMethodsAndDb;

import java.sql.*;

public class DbConnection {
    private static final String CONNECTION_STRING = "jdbc:mysql://oop.ibu.edu.ba:3306/mtest_db?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USERNAME = "mtestdb_usr";
    private static final String PASSWORD = "mtest97dbUSR";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
    }

    public static void getTicketsByStatus(String status) {
        String sql = """
                    SELECT id, seat_label, price_paid, payment_method 
                    FROM tickets 
                    WHERE status = ?
                    """;
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String seatLabel = rs.getString("seat_label");
                double pricePaid = rs.getDouble("price_paid");
                String paymentMethod = rs.getString("payment_method");
                System.out.println(id + " -> " + seatLabel + " -> " + pricePaid + " -> " + paymentMethod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getTicketsByStatus("Booked");
    }
}