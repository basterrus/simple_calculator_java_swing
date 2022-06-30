package listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcListener implements ActionListener {

    private JTextField textField;

    public CalcListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String expression = textField.getText();
        float result = 0;
        String[] operators;
        if (expression.contains("+")) {
            operators = expression.split("\\+");
            result = Integer.parseInt(operators[0].trim()) + Integer.parseInt(operators[1].trim());
            System.out.println(result);
        } else if (expression.contains("-")) {
            operators = expression.split("-");
            result = Integer.parseInt(operators[0].trim()) - Integer.parseInt(operators[1].trim());
        } else if (expression.contains("*")) {
            operators = expression.split("\\*");
            result = Integer.parseInt(operators[0].trim()) * Integer.parseInt(operators[1].trim());
        } else if (expression.contains("/")) {
            operators = expression.split("/");
            if (Integer.parseInt(operators[1].trim()) == 0) {
                JOptionPane.showMessageDialog(null, "Zero divide division", "Error",
                        JOptionPane.WARNING_MESSAGE);
                result = 0;
            } else {
                result = Float.parseFloat(operators[0].trim()) / Float.parseFloat(operators[1].trim());
            }
        }
        textField.setText(String.valueOf(Float.valueOf(result)));
    }
}
