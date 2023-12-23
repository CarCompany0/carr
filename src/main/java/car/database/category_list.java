package car.database;

import org.example.Product;

import java.util.ArrayList;
import java.util.List;

public class category_list {

    private static final List<Product> p_listing = new ArrayList<Product>();

    static{
        p_listing.add(new Product("Interior", "stearing cover","des","url","50",true));
        p_listing.add(new Product("Interior", "backseat cover","des","url","30",true));
        p_listing.add(new Product("Exterior", "camera","des","url","100",false));
        p_listing.add(new Product("Exterior", "LED headlights","des","url","120",true));
        p_listing.add(new Product("Exterior", "Wheel locks","des","url","50",false));
        p_listing.add(new Product("Electronics", "tint","des","url", "99",false));
        p_listing.add(new Product("Electronics", "Remote car starters","des","url", "88",true));
        p_listing.add(new Product("Electronics", "Parking sensors","des","url", "50",true));

    }
    public static List<Product> getProduct() {
        return p_listing;
    }
    public static void addProduct (Product p){
        p_listing.add(p);
    }
}

