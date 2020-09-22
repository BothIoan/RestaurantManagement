package PresentationLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddNewProductUI extends JFrame {
    java.awt.Button newMenuItem = new Button("Submit");
    TextField name = new TextField(100);
    Label nameL = new Label("Insert name:");
    TextField price = new TextField(100);
    Label priceL = new Label("Insert production cost :");
    Label selectL = new Label("Select items to order :");
    Panel filler = new Panel();
    Panel filler2 = new Panel();
    Panel filler3 = new Panel();
    Panel tf1 = new Panel();
    Panel tf2 = new Panel();
    Panel B = new Panel();
        public AddNewProductUI(Restaurant restaurant){
            setLayout(new GridLayout(3,3));
            setSize(500,500);
            setTitle("Admin");
            setLocationRelativeTo(null);
            setVisible(true);
            CheckableItem[] items = formCHItem(restaurant.GetAllNames());
            CheckedComboBox<CheckableItem> selection = new CheckedComboBox<CheckableItem>(new DefaultComboBoxModel<CheckableItem>(items));
            add(nameL);
            add(priceL);
            add(selectL);
            tf1.setLayout(new GridLayout(4,1));
            tf2.setLayout(new GridLayout(4,1));
            tf1.add(name);
            tf2.add(price);
            add(tf1);
            add(tf2);
            B.setLayout(new GridLayout(4,1));
            B.add(newMenuItem);
            filler3.setLayout(new GridLayout(4,1));
            filler3.add(selection);
            add(filler3);
            add(filler);
            add(filler2);
            newMenuItem.setSize(10,10);
            add(B);
            newMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(price == null)
                    {
                        new ErrorJframe("Input a production cost");
                    }else {
                        restaurant.createNewProduct(name.getText(), Integer.parseInt(price.getText()), restaurant.getObjectsByNames(CheckBoxCellRenderer.getCheckedItemString(selection.getModel()).split(", ")));
                        selection.addItem(new CheckableItem(name.getText(),false));
                    }
                }
            });
            SwingUtilities.getRootPane(newMenuItem);
        }
    public CheckableItem[] formCHItem(String[] names){
        CheckableItem[] aux = new CheckableItem[names.length];
        for(int k=0 ; k<names.length ; k++){
            aux[k]= new CheckableItem(names[k],false);
        }
        return aux;
    }
}
