package BusinessLayer;

import java.io.Serializable;
import java.util.ArrayList;
public interface MenuItem extends Serializable{
     // int computePrice();
     String getName();
     Integer getPrice();
     void setName(String name);
     void setPrice(int price);
     MenuItem setComposites(ArrayList<MenuItem> items);
     ArrayList getEverything();

}
