import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyGUIProgram extends JFrame implements ActionListener {

    // private variables
    private JComboBox choiceOperation;
    private JButton btnEnter;
    private JPanel panelBtns, panelMatrices, panelMat1, panelMat1Mat, panelMat2, panelMat2Mat, panelOutput;


//    private int sum = 0;

    // Constructor
    public MyGUIProgram() {

//        JPanel panelButtons = new JPanel(new FlowLayout());


//        Container cp = getContentPane();
//        cp.setLayout(new GridLayout(2,2,5,5));
//
//        cp.add(new JLabel("Enter an Integer"));
//
//        tfInput = new JTextField(10);
//        cp.add(tfInput);
//
//        cp.add(new JLabel("The accumulated sum is: "));
//
//        tfOutput = new JTextField(10);
//        tfOutput.setEditable(false);
//        cp.add(tfOutput);

//        btnCount = new JButton("Count");
//        cp.add(btnCount);
//
//        btnCount.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ++count;
//                tfCount.setText(count + "");
//            }
//        });

//        tfInput.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int numberIn = Integer.parseInt(tfInput.getText());
//                sum += numberIn;
//                tfInput.setText("");
//                tfOutput.setText(sum + "");
//            }
//        });

        // Panel Stuff
        panelBtns = new JPanel(new FlowLayout());
        add(panelBtns);

        String[] operations = { "Add", "Subtract", "Multiply" };
        choiceOperation = new JComboBox(operations);
        choiceOperation.addActionListener(this);
        panelBtns.add(choiceOperation);

        panelMatrices = new JPanel(new FlowLayout());
        add(panelMatrices);

        panelMat1 = new JPanel(new FlowLayout());
        panelMatrices.add(panelMat1);

        panelMat1Mat = new JPanel(new GridLayout(2, 2));
        panelMat1.add(panelMat1Mat);

        JTextField val1 = new JTextField(5);
        JTextField val2 = new JTextField(5);
        JTextField val3 = new JTextField(5);
        JTextField val4 = new JTextField(5);

        panelMat1Mat.add(val1);
        panelMat1Mat.add(val2);
        panelMat1Mat.add(val3);
        panelMat1Mat.add(val4);

        panelMat2Mat = new JPanel(new GridLayout(2, 2));
        panelMat1.add(panelMat2Mat);

        JTextField val5 = new JTextField(5);
        JTextField val6 = new JTextField(5);
        JTextField val7 = new JTextField(5);
        JTextField val8 = new JTextField(5);

        panelMat1Mat.add(val5);
        panelMat1Mat.add(val6);
        panelMat1Mat.add(val7);
        panelMat1Mat.add(val8);


        // Frame Stuff
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setTitle("Jonathan's Linear Algebra Calculator");



        pack();
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == choiceOperation) {
            System.out.println(choiceOperation.getSelectedItem());
        }
    }

    public void generateMatrix(int height, int width, JPanel panel) {
        panel.add( new JPanel(new GridLayout(height, width)) );

        for (int i = 0; i < height * width; ++i) {
            JTextField newVal = new JTextField(5);
        }
    }

    // The entry main() method
    public static void main(String[] args) {
        new MyGUIProgram();
    }
}
