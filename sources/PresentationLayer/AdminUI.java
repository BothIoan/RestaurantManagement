package PresentationLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class AdminUI extends JFrame {

    private Button newMenuItem = new Button("add Item");
    private Button delMenuItem = new Button("delete Item");
    private Button editMenuItem = new Button("edit Item");
    private Panel test = new Panel();

    public AdminUI(Restaurant restaurant){

        setLayout(new GridLayout(1,1));
        setSize(500,500);
        setTitle("Admin");
        setLocationRelativeTo(null);
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddNewProductUI(restaurant);
            }
        });
        delMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteProductUI(restaurant);
            }
        });
        editMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new selectToEdit(restaurant);
            }
        });

        test.add(newMenuItem);
        test.add(delMenuItem);
        test.add(editMenuItem);
        add(test);
        test.setVisible(true);
        setVisible(true);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                RestaurantSerializer rs = new RestaurantSerializer(restaurant);
                rs.storeMenu();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

}
