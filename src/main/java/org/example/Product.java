package org.example;

import car.database.CategoryList;
import project.najah.edu.ErrorMsg;
import project.najah.edu.Menu;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Product {
    private static final PrintWriter writer = new PrintWriter(System.out, true);
    public static void println(String message) {print(message);}
    private static void print(String output) {writer.println(output);}
    private static final String RESET = "\u001B[0m";
    private static final String SET =  "\u001B[35m";

    private static final Logger LOGGER = Logger.getLogger(Product.class.getName());
    private static final Scanner scan = new Scanner(System.in);
    private static final String LINE = "\u001b[35m--------------------------------------------\u001b[0m";
    private String type;
    public static int getNumProduct() {
        return numProduct;
    }
    public static void setNumProduct(int numProduct) {
        Product.numProduct = numProduct;
    }
    private static int numProduct = 0;
    private String name;
    private String description;
    private boolean availability;
    private String image;
    private String price;
    public static boolean isIsAdded() {
        return isAdded;
    }
    public static boolean isIsDeleted() {
        return isDeleted;
    }
    public static boolean isIsUpdated() {
        return isUpdated;
    }
    public static boolean isIsDisplayed() {
        return isDisplayed;
    }

    public static boolean isAdded = false;
    public static boolean isDisplayed() {
        return isDisplayed;
    }

    public static boolean isAdded() {
        return isAdded;
    }

    public static boolean isDeleted() {
        return isDeleted;
    }

    public static boolean isUpdated() {
        return isUpdated;
    }
    public static boolean isDeleted = false;

    public static boolean isUpdated = false;

    public static boolean isDisplayed = false;

    public Product(String type, String name, String description, String image, String price, boolean availability) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.availability = availability;
    }

    public static void showError() {
        isUpdated = false;
        isAdded = false;
        LOGGER.info("\u001B[34mPlease fill all fields\u001B[0m");
    }

    public static void showError2() {
        isUpdated = false;
        isDeleted = false;
        LOGGER.info("\u001B[34mInvalid product index \u001B[0m");
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public static void viewProducts(List<Product> productList) {

        int i = 1;

        for (Product product : productList) {
            String s = i + "- " + product.getType() + " , " + product.getName() + " , " + product.getDescription() +
                    " , " + product.getImage() + " , " + product.getPrice() + " $ " + " , " + product.isAvailability();
            println(SET+ s + RESET);
            i++;
            isDisplayed = true;

        }
        numProduct = i;
    }
    private static Product getProductInfo() {
        LOGGER.info("\u001b[35mEnter new type:\u001b[0m");
        String type = scan.next();

        LOGGER.info("\u001b[35mEnter new product name:\u001b[0m");
        String pname = scan.next();

        LOGGER.info("\u001b[35mEnter new description:\u001b[0m");
        String des = scan.next();

        LOGGER.info("\u001b[35mEnter new image URL:\u001b[0m");
        String url = scan.next();

        LOGGER.info("\u001b[35mEnter new price:\u001b[0m");
        String price = scan.next();

        LOGGER.info("\u001b[35mIs it available? (true/false):\u001b[0m");
        String avv = scan.next();

        if (type.isEmpty() || pname.isEmpty() || des.isEmpty() || url.isEmpty() || price.isEmpty() || avv.isEmpty()) {
            return null; // Indicates invalid input
        }
        boolean av = Boolean.parseBoolean(avv);
        return new Product(type, pname, des, url, price, av);
    }
    public static void updateByNum(int pnum) {

            List<Product> productList = CategoryList.getProduct();
            LOGGER.info(LINE);

            Product updatedProduct = getProductInfo();
            if (updatedProduct != null) {
                Product.updateProductByNum(productList, pnum, updatedProduct);

            } else {
                ErrorMsg.showError4();
            }
    }
    public static void updateByName(String pname) {

        List<Product> productList = CategoryList.getProduct();
        LOGGER.info(LINE);

        Product updatedProduct = getProductInfo();
        if (updatedProduct != null) {
            Product.updateProductByName(productList, pname, updatedProduct);

        } else {
            ErrorMsg.showError4();
        }

    }

    public static void removeProductByNum(List<Product> productList, int numProduct) {
        if (numProduct > 0 && numProduct <= productList.size()) {
            productList.remove(numProduct - 1);
            isDeleted = true;

            LOGGER.info("\u001B[32mProduct removed successfully.\u001B[0m");
        }

    }
    public static void removeProductByType(List<Product> productList, String typeToRemove) {
        // Iterate through the productList in reverse order to avoid concurrent modification issues
        productList.removeIf(product -> product.getType().equalsIgnoreCase(typeToRemove));

                LOGGER.info("\u001B[32mCategory Deleted successfully.\u001B[0m");
        isDeleted = true;
            }
    public static void removeProductByName(List<Product> productList, String nameToRemove) {
        // Iterate through the productList in reverse order to avoid concurrent modification issues

        for (int i = productList.size() - 1; i >= 0; i--) {
            Product product = productList.get(i);

            // Check if the product type matches the specified typeToRemove
            if (product.getName().equals(nameToRemove)) {
                // Remove the product from the list

                productList.remove(i);
                LOGGER.info("\u001B[32mProduct Deleted successfully.\u001B[0m");
            }

        }
        isDeleted = true;
    }
    public static void updateProductByNum(List<Product> productList, int numProduct, Product updatedProduct) {
        if (numProduct > 0 && numProduct <= productList.size()) {
            Product productToUpdate = productList.get(numProduct - 1);
            productToUpdate.setType(updatedProduct.getType());
            productToUpdate.setName(updatedProduct.getName());
            productToUpdate.setDescription(updatedProduct.getDescription());
            productToUpdate.setImage(updatedProduct.getImage());
            productToUpdate.setPrice(updatedProduct.getPrice());
            productToUpdate.setAvailability(updatedProduct.isAvailability());
            isUpdated = true;

            LOGGER.info("\u001B[32mProduct Updated successfully.\u001B[0m");
        } else {
            isUpdated = false;
            LOGGER.info("Invalid product number. Please enter a valid product number.");
        }
    }
    public static void updateProductByName(List<Product> productList,String oldN, Product updatedProduct) {
        for (Product productToUpdate : productList) {
            if (productToUpdate.getName().equalsIgnoreCase(oldN)) {
                productToUpdate.setType(updatedProduct.getType());
                productToUpdate.setName(updatedProduct.getName());
                productToUpdate.setDescription(updatedProduct.getDescription());
                productToUpdate.setImage(updatedProduct.getImage());
                productToUpdate.setPrice(updatedProduct.getPrice());
                productToUpdate.setAvailability(updatedProduct.isAvailability());
                LOGGER.info("\u001B[32mProduct Updated successfully.\u001B[0m");
            }
        }
    }
    public static void addProduct(List<Product> productList, String newType, String newName, String newDes,
                                  String newImg, String newPrice, String newAva) {
        // Create a new Product with the provided information
        Product newProduct = new Product(newType, newName, newDes, newImg, newPrice, Boolean.parseBoolean(newAva));
        // Add the new product to the productList
        productList.add(newProduct);
        isAdded=true;
        LOGGER.info("\u001B[32mProduct Added successfully.\u001B[0m");
    }
    public static void add(){
        List<Product> productList;
        productList = CategoryList.getProduct();

        LOGGER.info(LINE);
        LOGGER.info("\u001b[35mEnter Categry:\u001b[0m");
        String cat = scan.next();

        LOGGER.info("\u001b[35mEnter Product Name:\u001b[0m");
        String namee = scan.next();

        LOGGER.info("\u001b[35mEnter Description:\u001b[0m");
        String dess = scan.next();

        LOGGER.info("\u001b[35mEnter Image:\u001b[0m");
        String imgg = scan.next();

        LOGGER.info("\u001b[35mEnter Price:\u001b[0m");
        String pr = scan.next();

        LOGGER.info("\u001b[35mIs it available? (true/false):\u001b[0m");
        String avv = scan.next();

        if (cat.isEmpty() || namee.isEmpty() || dess.isEmpty() || imgg.isEmpty() || pr.isEmpty() || avv.isEmpty()) {
            ErrorMsg.showError4();
        }
        // Call the updateUserByNum method with the desired user number and new information
        Product.addProduct(productList, cat,namee,dess,imgg,pr,avv);
        Product.viewProducts(productList);
    }
    public static void search(List<Product> productList) {
        List<Product> product1;
        product1 = CategoryList.getProduct();

        Menu.searchList();
        String select = scan.nextLine();

        if (select.equals("1")) {
            LOGGER.info("\u001b[35mEnter the product name:\u001b[0m");
            String pname = scan.nextLine();

            boolean isExisted = false;
            for (int i = 0; i < productList.size(); i++) {
                Product product = productList.get(i);
                if (product.getName().equalsIgnoreCase(pname)) {
                    String productInfo = "\u001b[35m" + i + ". " + product.getType() + " , " + product.getName() +
                            " , " + product.getDescription() + " , " + product.getImage() +
                            " , " + product.getPrice() + " $ " + " , " + product.isAvailability() + "\u001b[0m";
                    println(SET + productInfo + RESET);

                    isExisted = true;
                    // Ask if the user wants to buy the product
                    Menu.manageProducts();
                    String choose = scan.nextLine();

                    // Process the user's decision
                    switch (choose) {
                        case "1":
                            // Pass the index of the selected product to the PlaceOrder method
                            updateByName(product.getName());
                            break;

                        case "2":
                            removeProductByName(product1, product.getName());
                            break;

                        case "3":
                            // No action needed for option 3
                            break;

                        default:
                            ErrorMsg.showWarning();
                            break;
                    }
                    // Break out of the loop since the product is found
                }
            }
            if (!isExisted) {
                LOGGER.info("\u001b[34mProduct not found. Please check the product name and try again.\u001b[0m");
            }
        }
        else if (select.equals("2")) {
            LOGGER.info("\u001b[35mEnter the product Category:\u001b[0m");
            String searchProductType = scan.nextLine();
            boolean isExisted2 = false;

            // Display all products of the specified category
            for (int i = 0; i < productList.size(); i++) {
                Product product = productList.get(i);
                if (product.getType().equalsIgnoreCase(searchProductType)) {
                    String productInfo = "\u001b[35m" + i + ". " + product.getType() + " , " + product.getName() +
                            " , " + product.getDescription() + " , " + product.getImage() +
                            " , " + product.getPrice() + " $ " + " , " + product.isAvailability() + "\u001b[0m";
                    println(SET+ productInfo +RESET);
                    isExisted2 = true;
                }
            }
            if (isExisted2) {
                LOGGER.info("\u001b[35m Do You Want to Delete Category (yes/no): \u001b[0m");
                String choose = scan.nextLine();

                if (choose.equalsIgnoreCase("yes")) {
                    removeProductByType(productList, searchProductType);
                } else if (choose.equalsIgnoreCase("no")) {
                    LOGGER.info("\u001b[34mMaybe next time. Have a great day!\u001b[0m");
                } else {
                    ErrorMsg.showWarning();
                }
            } else {
                LOGGER.info("\u001b[34mCategory not found. Please check the Category name and try again.\u001b[0m");
            }
        }

        else if (select.equals("3")){
            return;
        }
        else
            ErrorMsg.showWarning();

    }
    }




