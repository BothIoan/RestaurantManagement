package PresentationLayer;

import BusinessLayer.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectToEdit extends JFrame {

    public selectToEdit(Restaurant restaurant){
        setLayout(new GridLayout(5,1));
        setSize(500,500);
        setTitle("select item to edit");
        setLocationRelativeTo(null);
        setVisible(true);
        String[] choices =restaurant.GetAllNames();
        final JComboBox cb =new JComboBox(choices);
        Button submit = new Button("Select this item ");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditProductUI(restaurant,(String)cb.getSelectedItem());
                dispose();
            }
        });
        add(cb);
        add(new Panel());
        add(new Panel());
        add(submit);

    }
}
