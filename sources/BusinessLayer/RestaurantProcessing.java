package BusinessLayer;

import java.util.ArrayList;

public interface RestaurantProcessing {
    /**
     *
     * @param  name
     * @throws NullPointerException if (name == null)
     * @param  price
     * @throws IllegalArgumentException if(price <=0)
     *
     */
    static void createNewProduct(String name ,int price , ArrayList<MenuItem> composite){}

    /**
     *
     * @pre itemsToRemove != null
     *
     */
    static void deleteItems (ArrayList<MenuItem> itemsToRemove){}

    /**
     *
     * @invariant menuItem.size();
     */
    static void editItem(MenuItem menuItem){}

    /**
     *
     * @pre orderedItems !=null;
     * @pre (table > 0 && table <=20)
     */
    static void createOrder(ArrayList<MenuItem> orderedItems,int table){}

    /**
     *
     *
     */
    static String[] GetAllNames(){return null;}

    /**
     *
     *
     *
     */
    static ArrayList<MenuItem> getObjectsByNames(String[] aux){return null;}
}