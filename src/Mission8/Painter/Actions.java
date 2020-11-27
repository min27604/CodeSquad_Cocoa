package Mission8.Painter;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Actions implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {
        Checkbox cb = (Checkbox) e.getSource();
        PainterFrame.checkboxChecker = cb.getLabel();
        System.out.println(PainterFrame.checkboxChecker);
    }
}
