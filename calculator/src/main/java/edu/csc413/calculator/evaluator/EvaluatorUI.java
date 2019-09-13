package edu.csc413.calculator.evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();
    Evaluator expressionEvaluator = new Evaluator();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
            "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
            "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression (or entry), clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[bText.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.txField.setPreferredSize(new Dimension(600, 50));
        this.txField.setFont(new Font("Courier", Font.BOLD, 28));

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button bt;
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            bt = new Button(bText[i]);
            bt.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = bt;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This function is triggered anytime a button is pressed
     * on our Calculator GUI.
     * @param eventObject Event object generated when a
     *                    button is pressed.
     */
    public void actionPerformed(ActionEvent eventObject) {
        if(eventObject.getSource() == buttons[0])
            txField.setText((txField.getText() + "7"));
        else if(eventObject.getSource() == buttons[1])
            txField.setText((txField.getText() + "8"));
        else if(eventObject.getSource() == buttons[2])
            txField.setText((txField.getText() + "9"));
        else if(eventObject.getSource() == buttons[3])
            txField.setText((txField.getText() + "+"));
        else if(eventObject.getSource() == buttons[4])
            txField.setText((txField.getText() + "4"));
        else if(eventObject.getSource() == buttons[5])
            txField.setText((txField.getText() + "5"));
        else if(eventObject.getSource() == buttons[6])
            txField.setText((txField.getText() + "6"));
        else if(eventObject.getSource() == buttons[7])
            txField.setText((txField.getText() + "-"));
        else if(eventObject.getSource() == buttons[8])
            txField.setText((txField.getText() + "1"));
        else if(eventObject.getSource() == buttons[9])
            txField.setText((txField.getText() + "2"));
        else if(eventObject.getSource() == buttons[10])
            txField.setText((txField.getText() + "3"));
        else if(eventObject.getSource() == buttons[11])
            txField.setText((txField.getText() + "*"));
        else if(eventObject.getSource() == buttons[12])
            txField.setText((txField.getText() + "0"));
        else if(eventObject.getSource() == buttons[13])
            txField.setText((txField.getText() + "^"));
        else if(eventObject.getSource() == buttons[14]){
            int result = expressionEvaluator.eval(txField.getText());
            txField.setText("");
            txField.setText(txField.getText()+ result);
        }
        else if(eventObject.getSource() == buttons[15])
            txField.setText((txField.getText() + "/"));
        else if(eventObject.getSource() == buttons[16])
            txField.setText((txField.getText() + "("));
        else if(eventObject.getSource() == buttons[17])
            txField.setText((txField.getText() + ")"));
        else if(eventObject.getSource() == buttons[18]){
            String currentString = txField.getText();
            if(!currentString.equals(""))
                txField.setText(currentString.substring(0, currentString.length()-1));

        }
        else
            txField.setText((""));
    }
}
