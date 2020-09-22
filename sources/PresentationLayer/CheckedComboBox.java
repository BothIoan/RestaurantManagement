
package PresentationLayer;

import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// copied from some shady sites
class CheckedComboBox<E extends CheckableItem> extends JComboBox<E> {
    private boolean keepOpen;
    private transient ActionListener listener;

    protected CheckedComboBox(){
        super();
    }

    protected CheckedComboBox(ComboBoxModel<E> aModel) {
        super(aModel);
    }

    protected CheckedComboBox(E[] m){
        super(m);
    }

    @Override public Dimension getPreferredSize(){
        return new Dimension(100,20);
    }

    @Override public void updateUI(){
        setRenderer(null);
        removeActionListener(listener);
        super.updateUI();
        listener = e->{
            if(e.getModifiers() == InputEvent.BUTTON1_MASK){
                updateItem(getSelectedIndex());
                keepOpen = true;
            }
        };

        setRenderer(new CheckBoxCellRenderer());
        addActionListener(listener);
        getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,0),"checkbox-select");
        getActionMap().put("checkbox-select",new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Accessible a = getAccessibleContext().getAccessibleChild(0);
                if(a instanceof BasicComboPopup){
                    BasicComboPopup pop = (BasicComboPopup) a;
                    updateItem(pop.getList().getSelectedIndex());
                }
            }
        });
    }

    private void updateItem(int index) {
        if (isPopupVisible()) {
            E item = getItemAt(index);
            item.selected ^= true;
            removeItemAt(index);
            insertItemAt(item, index);
            setSelectedItem(item);
        }
    }

    @Override public void setPopupVisible(boolean v) {
        if (keepOpen) {
            keepOpen = false;
        } else {
            super.setPopupVisible(v);
        }
    }
}

class CheckBoxCellRenderer<E extends CheckableItem> implements ListCellRenderer<E> {
    private final JLabel label = new JLabel(" ");
    private final JCheckBox check = new JCheckBox(" ");
    @Override public Component getListCellRendererComponent(JList list, CheckableItem value, int index, boolean isSelected, boolean cellHasFocus) {
        if (index < 0) {
            label.setText(getCheckedItemString(list.getModel()));
            //System.out.println(getCheckedItemString(list.getModel()));
            return label;
        } else {
            check.setText(Objects.toString(value, ""));
            check.setSelected(value.selected);
            if (isSelected) {
                check.setBackground(list.getSelectionBackground());
                check.setForeground(list.getSelectionForeground());
            } else {
                check.setBackground(list.getBackground());
                check.setForeground(list.getForeground());
            }
            return check;
        }
    }
    public static String getCheckedItemString(ListModel model) {
        List<String> sl = new ArrayList<String>();
        for (int i = 0; i < model.getSize(); i++) {
            Object o = model.getElementAt(i);
            if (o instanceof CheckableItem && ((CheckableItem) o).selected) {
                sl.add(o.toString());
            }
        }
        return sl.stream().sorted().collect(Collectors.joining(", "));
    }
}

class CheckableItem {
    public final String text;
    public boolean selected;
    protected CheckableItem(String text, boolean selected) {
        this.text = text;
        this.selected = selected;
    }
    @Override public String toString() {
        return text;
    }
}
