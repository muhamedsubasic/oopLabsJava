package LabMethodsAndDb;

import com.mysql.cj.x.protobuf.MysqlxCrud;

public class StatusOfOrders {
    public enum OrderStatus{
        PENDING, SHIPPED, DELIVERED, CANCELLED
    }
    public static void ordersStats(OrderStatus order){
        if (order == OrderStatus.PENDING){
            System.out.println("Order Pending");
        } else if (order == OrderStatus.SHIPPED) {
            System.out.println("Order Shipped");
        } else if (order == OrderStatus.DELIVERED) {
            System.out.println("Order Delivered");
        } else if (order == OrderStatus.CANCELLED) {
            System.out.println("Order cancelled");
        }
    }

    public static void main(String[] args) {
        ordersStats(OrderStatus.PENDING);
        ordersStats(OrderStatus.SHIPPED);
        ordersStats(OrderStatus.DELIVERED);
        ordersStats(OrderStatus.CANCELLED);
    }
}
