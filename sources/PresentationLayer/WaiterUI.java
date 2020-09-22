package PresentationLayer;
import BusinessLayer.MainClassPackage.MainClass;
import BusinessLayer.MenuItem;
import BusinessLayer.Observable;
import BusinessLayer.Restaurant;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WaiterUI extends Observable {

    Button newOrder = new Button("place Order");
    Panel test = new Panel();
    public WaiterUI(Restaurant restaurant){
         JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1,1));
        frame.setSize(500,500);
        frame.setTitle("Waiter");
        frame.setLocationRelativeTo(null);
        newOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    PlaceOrder placeOrder = new PlaceOrder(restaurant);
            }
        });
        test.add(newOrder);
        test.add(new Panel());
        frame.add(test);
        test.setVisible(true);
        frame.setVisible(true);
    }

}
