package org.example;

import java.util.List;
import java.util.logging.Logger;

public class Product {
    private static final String RESET = "\u001B[0m";
    private static final String SET =  "\u001B[35m";

    private static final Logger LOGGER = Logger.getLogger(Product.class.getName());
    private String type;
    public static int getNumProduct() {
        return numProduct;
    }
    private static int numProduct = 0;
    private String name;
    private String description;
    private boolean availability;
    private String image;
    private String price;


    public static boolean isAdded = false;


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
           LOGGER.info(SET+ s + RESET);
            i++;

        }
        numProduct = i;
    }


    public static void removeProductByNum(List<Product> productList, int numProduct) {
        if (numProduct > 0 && numProduct <= productList.size()) {
            productList.remove(numProduct - 1);
            isDeleted = true;

            LOGGER.info("\u001B[32mProduct removed successfully.\u001B[0m");
        }
        isUpdated = false;
        LOGGER.info("\u001B[34mInvalid product number. Please enter a valid product number.\u001B[0m");

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
            LOGGER.info("\u001B[34mInvalid product number. Please enter a valid product number.\u001B[0m");
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



    }




