package BusinessLayer;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.time.LocalDate;
import java.util.*;

public class Restaurant extends Observable implements RestaurantProcessing{
    private static  ArrayList<MenuItem>menuItems = new ArrayList<>();
    public static Map<Order, ArrayList<MenuItem>> allOrders = new HashMap<>();
    public static int orderSize=10;

    public static int getOrderSize() {
        return orderSize;
    }

    public void createNewProduct(String name , int price , ArrayList<MenuItem> composite){
        assert name !=null;
        assert price <200;

        if((composite == null)||(composite.isEmpty())){
            menuItems.add(new BaseProduct(name,price));
        }
        else
        {
            CompositeProduct cp = new CompositeProduct(name,price,composite);
            menuItems.add(cp);
        }

    }
    public void createNewProduct(MenuItem item)
    {
        menuItems.add(item);
    }
    public void deleteItems (ArrayList<MenuItem> itemsToRemove){
        assert itemsToRemove != null;
        menuItems.removeAll(itemsToRemove);
    }
    public void createOrder(ArrayList<MenuItem> orderedItems,int table){
        Order order =new Order(orderedItems,table);
        allOrders.put(order,orderedItems);
        if(orderSize<orderedItems.size()) orderSize = orderedItems.size();
        notifyAllObservers();
    }
    public void deleteOrder(Order order) {
        allOrders.remove(order.hashCode(),order);
    }
    public ArrayList<MenuItem> getOrdereditems(Integer id , Integer table , Date date){
        return allOrders.get(id + table +date.hashCode());
    }
    public  ArrayList<MenuItem> getMenuItems()
    {
        return menuItems;
    }
    public void EditItem (String productName,int newPrice,String newName,ArrayList<MenuItem> newItems){
        for(MenuItem item:menuItems){
            if(item.getName()==productName){
                item.setName(newName);
                item.setPrice(newPrice);
                createNewProduct(item.setComposites(newItems));
                menuItems.remove(item);
                break;
            }
        }
    }
    public String[] GetAllNames(){
        ArrayList<MenuItem> aux2 = getMenuItems();
        String[] aux = new String[aux2.size()];
        int k=0;
        for(MenuItem item:getMenuItems()){
           aux[k++]=item.getName();
        }
        return aux;
    }
    public ArrayList<MenuItem> getObjectsByNames(String[] aux){
        if(aux[0].isEmpty())return null;
        ArrayList<MenuItem> forReturn = new ArrayList<>();
        ArrayList<MenuItem> items=getMenuItems();
        for(MenuItem aux2: items){
            for(int k= 0;k<aux.length;k++) {
                if (aux2.getName().equals(aux[k])) {
                    forReturn.add(aux2);
                    break;
                }
            }
        }
        return forReturn;
    }
}
