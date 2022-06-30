package components;

import javax.swing.*;
import java.awt.*;

public class InputJPanel extends JTextField {

    public InputJPanel()  {
        setEditable(false);
        setFont(new Font("TimesRoman", Font.ITALIC, 25));
        setMargin(new Insets(8, 8, 8, 0));
        setBackground(new Color(255, 255, 255));
        setText("0");

    }
}
