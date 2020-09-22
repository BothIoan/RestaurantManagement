package PresentationLayer;
import BusinessLayer.Order;
import BusinessLayer.Restaurant;
import BusinessLayer.MenuItem;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.PlainView;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class ChefUI extends JFrame implements Observer{
    JTable table = new JTable(rowsgen(getAllOrders(Restaurant.allOrders),Restaurant.getOrderSize()),collumngen(Restaurant.getOrderSize()));
    Restaurant restaurant;
    ArrayList<Order>orders;
    public ChefUI(Restaurant restaurant){
        this.restaurant=restaurant;
        setSize(500,500);
        setTitle("Chef");
        setLocationRelativeTo(null);

        JScrollPane sPane= new JScrollPane(table);
        sPane.setVisible(true);
        add(sPane);
        setVisible(true);
    }
    public String[]collumngen(int orderSize){
        String[] aux = new String[orderSize];
        for(int i = 1 ;i<= orderSize;i++){
            aux[i-1]= "Item "+ i;
        }
        return aux;
    }
    public String[][] rowsgen(ArrayList<Order> orders, int orderSize){
        int i=0;
        int j=0;
        String[][]aux= new String[orders.size()][orderSize];
        for(Order order:orders){
            for(MenuItem item:order.getOrderedItems()){
                aux[i][j]=item.getName();
                j++;
            }
            i++;
            j=0;
        }
        return aux;
    }
    private ArrayList<Order> getAllOrders(Map<Order, ArrayList<MenuItem>> map){
    ArrayList<Order> returnBox = new ArrayList<>();
    map.forEach((x,y)->returnBox.add(x));
    return returnBox;
    }
    public void update(){
        TableModel newModel = new DefaultTableModel(rowsgen(getAllOrders(Restaurant.allOrders),Restaurant.getOrderSize()),collumngen(Restaurant.getOrderSize()));
        table.setModel(newModel);
        ((AbstractTableModel) newModel).fireTableDataChanged();
        table.repaint();
        new ErrorJframe("New Order!");
    }
}
