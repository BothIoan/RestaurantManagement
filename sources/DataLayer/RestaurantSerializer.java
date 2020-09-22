package DataLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Restaurant;

import java.io.*;

public class RestaurantSerializer {
    Restaurant restaurant;
    public RestaurantSerializer(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    public void loadMenu() {
        File file = new File("savedmenu.ser");
        try {
            if (!file.createNewFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                while (true){

                    if(objectInputStream == null) break;
                    try {
                        MenuItem item = (MenuItem) objectInputStream.readObject();
                        restaurant.createNewProduct(item);
                    }
                    catch (ClassNotFoundException e) { }

                }
                fileInputStream.close();
                file.delete();
            }
        }
        catch(IOException e){}
    }
    public void storeMenu(){
        File file = new File("savedmenu.ser");
        try{
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for(MenuItem menuItem: restaurant.getMenuItems())
            {
                objectOutputStream.writeObject(menuItem);
            }
        }
        catch (IOException e){}
    }
}
