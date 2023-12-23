package org.example;

import car.database.category_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
public class Customer extends User {
    private static final Scanner scan = new Scanner(System.in);
    public static boolean isViewed() {
        return isViewed;
    }

    private static boolean isViewed=false;

    public static boolean isIsExisted() {
        return isExisted;
    }

    private static boolean isExisted = false;
    public static boolean isIsPlaced() {
        return isPlaced;
    }

    private static boolean isPlaced=false;

    public static boolean isIsSented() {
        return isSented;
    }

    public static boolean isSented=false;




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

    // Add an order for the customer


    // Display all orders for the customer
    public static void displayOrders() {
        if (oL.getOrderList() != null && !oL.getOrderList().isEmpty()) {
            int i = 1;
            for (Order order : oL.getOrderList()) {
                LOGGER.info("\u001b[35m" + i + "- " + " Product name: " + order.product.getName() + "  " +
                        "Quantity: " + order.quantity + "  " + "Order Total: " + order.getTotalPrice() + " $\u001b[0m");
                i++;
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

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotalPrice() {
            // Assuming the product's price is a String, parse it to double for calculation
            double productPrice = Double.parseDouble(product.getPrice());

            // Calculate total price
            return productPrice * quantity;
        }

        public static void PlaceOrder(List<Product> product, int selectedProductIndex) {

            // Create an instance of Customer
            Customer cus = new Customer(null, null, null, null);

            if (selectedProductIndex >= 0 && selectedProductIndex < product.size()) {
                Product selectedProduct = product.get(selectedProductIndex);

                if (selectedProduct.isAvailability()) {
                    LOGGER.info("\u001b[35mQuantity:\u001b[0m");
                    int quantity = scan.nextInt();

                    LOGGER.info("\u001b[35mYou have selected: \u001b[35m" + quantity + "\u001b[35m of \u001b[35m" +
                            selectedProduct.getName() + " " + selectedProduct.getPrice() + "$" + "\u001b[0m");

                    // Add the order to the customer's order list
                    Customer.Order newOrder = new Customer.Order(selectedProduct, quantity);
                    oL.addOrder(newOrder);

                    LOGGER.info("\u001b[35mOrder Added Successfully To Cart \u001b[0m");

                    // Send order confirmation email
                    sendOrderConfirmationEmail(selectedProduct.getName(), quantity, newOrder.getTotalPrice());
                } else {
                    LOGGER.info("\u001b[34mThe Product Out Of Stock\u001b[0m");
                }
            }
        }

        public static void sendOrderConfirmationEmail(String productName, int quantity, double totalPrice) {
            String from= "lemarizeq@gmail.com";
            String to = "dana29454@gmail.com";

            String subject = "Order Confirmation";
            String messageText = "Thank you for your order!\n\n"
                    + "Product Name: " + productName + "\n"
                    + "Quantity: " + quantity + "\n"
                    + "Total Price: " + totalPrice + "$"+ "\n\n"
                    + "We appreciate your business.";
            isSented=true;

            EmailSender.sendEmail(from, to, subject, messageText);
        }
    }


    public static void search(List<Product>productList) {
        List<Product> product1;
        product1 = category_list.getProduct();


        LOGGER.info("\u001b[35mEnter the product name:\u001b[0m");
        String pname = scan.nextLine();
         isExisted = false;

        for (int i = 1; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getName().equalsIgnoreCase(pname)) {
                String productInfo = "\u001b[35m"+i + ". " + product.getType() + " , " + product.getName() +
                        " , " + product.getDescription() + " , " + product.getImage() +
                        " , " + product.getPrice() + " $ " + " , " + product.isAvailability()+"\u001b[0m";
                LOGGER.info("\u001B[35m" + productInfo + "\u001B[0m");

                isExisted = true;

                // Ask if the user wants to buy the product
                LOGGER.info("\u001b[35mDo you want to buy it? (yes/no): \u001b[0m");
                String buyDecision = scan.nextLine();

                // Process the user's decision
                if (buyDecision.equalsIgnoreCase("yes")) {
                    // Pass the index of the selected product to the PlaceOrder method
                    Order.PlaceOrder(product1, i);
                     break;
                } else if(buyDecision.equalsIgnoreCase("no")) {
                    LOGGER.info("\u001b[34mMaybe next time. Have a great day!\u001b[0m");
                    break;
                }
                else
                    LOGGER.info("\u001b[34mInvalid Input.please try again\u001b[0m");
                break;
              // Break out of the loop since the product is found
            }
        }

        if (!isExisted) {
            LOGGER.info("\u001b[34mProduct not found. Please check the product name and try again.\u001b[0m");
        }
    }
}
