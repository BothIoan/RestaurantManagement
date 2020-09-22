package BusinessLayer;

import java.util.ArrayList;
import java.io.Serializable;

 class CompositeProduct implements   MenuItem , Serializable{
    private String name;
    private  Integer price;
    ArrayList<MenuItem> compositeProducts ;

    public CompositeProduct(String name ,int price , ArrayList<MenuItem> composite){
        this.name = name;
        compositeProducts=composite;
        this.price = (Integer) this.getEverything().get(1)+price;
    }

    public void setName(String name ){this.name=name;}
    public void setPrice(int price){this.price=price;}
    public String getName(){return name;}
    public Integer getPrice(){return price;}

     public MenuItem setComposites(ArrayList<MenuItem> items){
         if(items== null)
             return new BaseProduct(name,price);
         else {
             compositeProducts =items;
             return this;
         }
     }
    public ArrayList getEverything (){
        ArrayList forReturn = new ArrayList();
        Integer finalPrice = 0;
        StringBuilder composites = new StringBuilder();
        composites .append("\n\n").append( name ).append("Ingredients:");
        for(MenuItem item :compositeProducts){
        composites.append(item.getName()).append("....").append(item.getPrice().toString()).append( "\n");
        finalPrice= finalPrice + item.getPrice();
        }
        composites.append("\n").append("Total : ").append(finalPrice.toString());
        forReturn.add(0,composites);
        forReturn.add(1,finalPrice);
        return forReturn;
    }
    protected  void addComposite(MenuItem composite){

    }
}
