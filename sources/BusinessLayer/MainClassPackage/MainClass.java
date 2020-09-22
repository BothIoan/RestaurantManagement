package BusinessLayer.MainClassPackage;

import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializer;
import PresentationLayer.AdminUI;
import PresentationLayer.ChefUI;
import PresentationLayer.Observer;
import PresentationLayer.WaiterUI;

public class MainClass {

    public static void main (String[] args) {
        Restaurant restaurant = new Restaurant();
        RestaurantSerializer rs = new RestaurantSerializer(restaurant);
        rs.loadMenu();
        AdminUI UI = new AdminUI(restaurant);
        WaiterUI UI2 = new WaiterUI(restaurant);
        ChefUI UI3=new ChefUI(restaurant);
        restaurant.addObserver(UI3);
    }

}
