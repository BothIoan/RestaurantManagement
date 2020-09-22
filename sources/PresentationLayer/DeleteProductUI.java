package PresentationLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteProductUI extends JFrame {
    Button submit = new Button("Submit");
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();
    DeleteProductUI(Restaurant restaurant){
        setLayout(new GridLayout(5,1));
        setSize(500,500);
        setTitle("Admin");
        setLocationRelativeTo(null);
        CheckableItem[] items = formCHItem(restaurant.GetAllNames());
        CheckedComboBox<CheckableItem> selection = new CheckedComboBox<CheckableItem>(new DefaultComboBoxModel<CheckableItem>(items));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<MenuItem> toDelete = restaurant.getObjectsByNames(CheckBoxCellRenderer.getCheckedItemString(selection.getModel()).split(", "));

                for(int k=0 ; k<toDelete.size();k++){
                    int uu = selection.getSelectedObjects().length;
                    Object[] uu2 = selection.getSelectedObjects();
                    selection.removeItem(selection.getSelectedObjects()[0]);

                }
                restaurant.deleteItems(toDelete);
            }
        });
        add(submit);
        add(p1);
        add(p2);
        add(p3);
        add(selection);
        setVisible(true);
    }
    public CheckableItem[] formCHItem(String[] names){
        CheckableItem[] aux = new CheckableItem[names.length];
        for(int k=0 ; k<names.length ; k++){
            aux[k]= new CheckableItem(names[k],false);
        }
        return aux;
    }
}
