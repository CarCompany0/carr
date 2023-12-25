package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Customer extends User {
    public static void println(String message) {print(message);}
    private static void print(String output) {LOGGER.info(output);}
    public static boolean isViewed() {
        return isViewed;
    }
    private static final String RESET = "\u001B[0m";

    private static boolean isViewed=false;



    public static class Sss {
        private ArrayList<Order> orderList = new ArrayList<>();
        public Sss(){
            this.orderList = new ArrayList<>();
        }
        public List<Order> getOrderList() {
            return orderList;
        }
        public void addOrder(Order order) {
            orderList.add(order);
        }
    }
    public static final Sss oL = new Sss();
    private static final Logger LOGGER = Logger.getLogger(Customer.class.getName());

    public Customer(String username, String email, String location, String phoneNum) {
        super(username, email, null, "Customer", location, phoneNum);
    }
    // Display all orders for the customer
    public static void displayOrders() {
        if (oL.getOrderList() != null && !oL.getOrderList().isEmpty()) {

            for (Order order : oL.getOrderList()) {
                println("\u001B[34mProduct name:"+ order.product.getName()+RESET);
                println("\u001B[34mQuantity: " + order.quantity +RESET);
                println("\u001B[34mOrder Total: " + order.getTotalPrice()+RESET);
            }
            isViewed = true;
        } else {
            LOGGER.info("\u001b[34mNo orders to display.\u001b[0m");
        }
    }

    public static class Order{
        private final Product product;
        private final int quantity;

        public Order(Product product, int quantity){
            this.product=product;
            this.quantity=quantity;
        }



        public double getTotalPrice() {
            // Assuming the product's price is a String, parse it to double for calculation
            double productPrice = Double.parseDouble(product.getPrice());

            // Calculate total price
            return productPrice * quantity;
        }



        public void sendOrderConfirmationEmail(String productName, int quantity, double totalPrice) {
            String from= "lemarizeq@gmail.com";
            String to = "dana29454@gmail.com";

            String subject = "Order Confirmation";
            String messageText = "Thank you for your order!\n\n"
                    + "Product Name: " + productName + "\n"
                    + "Quantity: " + quantity + "\n"
                    + "Total Price: " + totalPrice + "$"+ "\n\n"
                    + "We appreciate your business.";


            EmailSender.sendEmail(from, to, subject, messageText);
        }
    }


}
