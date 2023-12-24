package car.database;

import org.example.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {

    private static final List<Product> p_listing = new ArrayList<>();
    private static final String EXTERIOR = "Exterior";
    public static final String ELECTRONICS = "Electronics";

    private CategoryList() {

    }

    static{
        p_listing.add(new Product("Interior", "Steering cover","des","url","50",true));
        p_listing.add(new Product("Interior", "backseat cover","des","url","30",true));
        p_listing.add(new Product(EXTERIOR, "camera","des","url","100",false));
        p_listing.add(new Product(EXTERIOR, "LED headlights","des","url","120",true));
        p_listing.add(new Product(EXTERIOR, "Wheel locks","des","url","50",false));
        p_listing.add(new Product(ELECTRONICS, "tint","des","url", "99",true));
        p_listing.add(new Product(ELECTRONICS, "Remote car starters","des","url", "88",true));
        p_listing.add(new Product(ELECTRONICS, "Parking sensors","des","url", "50",true));

    }
    public static List<Product> getProduct() {
        return p_listing;
    }

}

