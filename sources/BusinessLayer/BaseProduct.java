package BusinessLayer;
import java.io.Serializable;
import java.util.ArrayList;

class BaseProduct implements MenuItem , Serializable {
    private String name ;
    private  Integer price;
    protected BaseProduct(String name, int price){
        this.price = price;
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public Integer getPrice(){ return price; }
    public MenuItem setComposites(ArrayList<MenuItem> items){
        if(items == null){
            return this;
        }
        else return new CompositeProduct(name,price,items);
    }
    public ArrayList getEverything(){
        ArrayList forReturn= new ArrayList();
        forReturn.add(0,name +"...."+Integer.toString(price)+"\n");
        forReturn.add(1,price);
        return forReturn;
    }
}
