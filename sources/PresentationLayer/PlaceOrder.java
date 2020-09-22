package PresentationLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Observable;
import BusinessLayer.Restaurant;
import DataLayer.FileWriters;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlaceOrder extends Observable {
    JFrame frame = new JFrame();
    FileWriters aux = new FileWriters();
    public PlaceOrder(Restaurant restaurant){
        frame.setLayout(new GridLayout(5,1));
        frame.setSize(500,500);
        frame.setTitle("place order");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        CheckableItem[] items = formCHItem(restaurant.GetAllNames());
        CheckedComboBox<CheckableItem> selection = new CheckedComboBox<CheckableItem>(new DefaultComboBoxModel<CheckableItem>(items));
        TextField tf = new TextField();
        Label table = new Label("insert table:");
        Button submit = new Button("Submit");
        Panel filler = new Panel(new GridLayout(1,2));
        filler.add(new Panel());
        filler.add(submit);
        Panel filler2 = new Panel(new GridLayout(2,1));
        Panel filler3 = new Panel(new GridLayout(2,1));
        filler2.add(new Panel());
        filler2.add(tf);
        filler3.add(selection);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    ArrayList<MenuItem> items = restaurant.getObjectsByNames(CheckBoxCellRenderer.getCheckedItemString(selection.getModel()).split(", "));
                    restaurant.createOrder(items, Integer.parseInt(tf.getText()));
                    aux.createBill(items);

            }
        });
        frame.add(table);
        frame.add(filler2);
        frame.add(new Panel());
        frame.add(filler3);
        frame.add(filler);
    }
    public CheckableItem[] formCHItem(String[] names){
        CheckableItem[] aux = new CheckableItem[names.length];
        for(int k=0 ; k<names.length ; k++){
            aux[k]= new CheckableItem(names[k],false);
        }

        return aux;
    }
}
