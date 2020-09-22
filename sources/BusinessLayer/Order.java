package BusinessLayer;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDate;
public class Order {
    private static int count;
    private static int id=0;
    private int table;
    private LocalDate date;
    private ArrayList<MenuItem>OrderedItems;
    public Order(ArrayList<MenuItem>OrderedItems,int table){
        id++;
        table = table;
        date = LocalDate.now();
        assert  OrderedItems !=null;
        this.OrderedItems=OrderedItems;
    }
    public ArrayList<MenuItem> getOrderedItems(){return OrderedItems;}
    public int hashCode(int table) {
        return id+table+date.hashCode();
    }
}
