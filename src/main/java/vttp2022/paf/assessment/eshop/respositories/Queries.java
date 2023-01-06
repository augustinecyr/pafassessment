package vttp2022.paf.assessment.eshop.respositories;

public class Queries {
    public static String SQL_INSERT_CUSTOMERS = "insert into customers(name, address, email) values (?, ?, ?)";
    public static String SQL_INSERT_ORDER= "insert into order(orderId, deliveryId, name, address, email, status, orderDate) values (?,?,?,?,?,?,SYSDATE())";
    public static String SQL_ALL_CUSTOMER= "SELECT * from customers";
    public static String SQL_FIND_CUSTOMER_BY_NAME ="SELECT * from customers where name = ?";
    public static String SQL_INSERT_LINEITEM= "insert into lineitem(item, quantity, orderId) values (?,?,?)";
    public static String SQL_ORDERSTATUS = "select * from order_status";
   
}
