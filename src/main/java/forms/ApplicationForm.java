package forms;

import components.InputJPanel;
import components.NumberJButton;
import components.OperatorJButton;
import listener.ButtonListener;
import listener.CalcListener;
import listener.ClearButtonListener;
import listener.ExitButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;

    public ApplicationForm(String title) throws HeadlessException {
        super(title);
        setBounds(400, 400, 350, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setAlwaysOnTop(true);
        setJMenuBar(createMenu());
        setLayout(new BorderLayout());
        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
        setVisible(true);
    }

    private JMenuBar createMenu() {

        JMenuBar menuBar = new JMenuBar();


        JMenu menuFile = new JMenu("File");
        JMenu menuAbout = new JMenu("About");
        menuBar.add(menuFile);
        menuBar.add(menuAbout);


        JMenuItem clearItem = menuFile.add(new JMenuItem("Clear"));
        JMenuItem exitItem = menuFile.add(new JMenuItem("Exit"));
        JMenuItem helpItem = menuFile.add(new JMenuItem("Help"));


        menuFile.add(clearItem);
        menuFile.add(exitItem);
        menuAbout.add(helpItem);


        exitItem.addActionListener(new ExitButtonListener());
        clearItem.addActionListener(new ClearButtonListener(inputField));
        return menuBar;
    }

    private JPanel createTopPanel() {

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new InputJPanel();
        top.add(inputField);

        return top;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        ActionListener buttonListener = new ButtonListener(inputField);
        centerPanel.add(createDigitsPanel(buttonListener), BorderLayout.CENTER);
        centerPanel.add(createOperatorsPanel(buttonListener), BorderLayout.WEST);

        return centerPanel;
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) {

        JPanel digitsPanel = new JPanel();
        digitsPanel.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i + 1);
            JButton btn = new NumberJButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);
        }

        JButton calc = new OperatorJButton("=");
        digitsPanel.add(calc);
        calc.addActionListener(new CalcListener(inputField));

        JButton clear = new OperatorJButton("C");
        digitsPanel.add(clear);
        clear.addActionListener(new ClearButtonListener(inputField));

        return digitsPanel;
    }

    private JPanel createOperatorsPanel(ActionListener buttonListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton minus = new OperatorJButton("-");
        minus.addActionListener(buttonListener);
        panel.add(minus);

        JButton plus = new OperatorJButton("+");
        plus.addActionListener(buttonListener);
        panel.add(plus);

        JButton multiply = new OperatorJButton("*");
        multiply.addActionListener(buttonListener);
        panel.add(multiply);

        JButton divide = new OperatorJButton("/");
        divide.addActionListener(buttonListener);
        panel.add(divide);


        return panel;
    }


}
