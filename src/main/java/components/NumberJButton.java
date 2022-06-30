package components;

import javax.swing.*;
import java.awt.*;

public class NumberJButton extends JButton {
    public NumberJButton(String text) {
        super(text);
        setFont(new Font("TimesRoman", Font.PLAIN, 25));
        setBackground(new Color(225, 233, 245));
    }
}
