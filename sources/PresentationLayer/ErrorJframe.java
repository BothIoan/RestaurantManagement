package PresentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorJframe extends JFrame {
    Label Error = new Label("");
    Button ok = new Button("ok");

    public ErrorJframe(String error) {
        setSize(300, 200);
        setTitle("!");
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new GridLayout(2, 1));
        Error.setText(error);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(Error);
        add(ok);
    }
}
