package calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GraphicInterface extends JFrame {
    private JButton [] btn = new JButton[14];         // ��ư
    private JTextField exprTextfield = new JTextField(10);      // ù ��° �ؽ�Ʈ �ʵ�
    private JTextField resultTextfield = new JTextField(10);   // �� ��° �ؽ�Ʈ �ʵ�
    //private int [] changeOperand = new int[10];         // ���� �Լ��� �̿��ؼ� �ι�° �ǿ����ڸ� ó���ϱ� ���� �迭
    private int firstOperand = 0;
    private int secondOperand = 0;
    private char operator;
    
    public GraphicInterface() {
        this.setTitle("������ ����");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Container c = getContentPane();

        c.setLayout(new BorderLayout(3, 3));

        c.add(new FirstPanel(), BorderLayout.NORTH);
        c.add(new SecondPanel());
        c.add(new ThirdPanel(),BorderLayout.SOUTH);

        this.setSize(300, 300);
        this.setVisible(true);

    }

    private class FirstPanel extends JPanel {      // ù ��° �г� ����
        public FirstPanel() {
            setBackground(Color.GRAY);
            setLayout(new GridLayout(2,1));

            add(new JLabel("����"));

            add(exprTextfield);
            exprTextfield.setEditable(false);      // ����ڰ� Ű����� ���� �Է��� �� ������ ó��

            add(new JLabel("���"));

            add(resultTextfield);
            resultTextfield.setEditable(false);      // ����ڰ� Ű����� ���� �Է��� �� ������ ó��
        }
    }
    private class SecondPanel extends JPanel{
        public SecondPanel() {
            setLayout(new GridLayout(3, 4, 5, 5));

            for(int i = 0; i < 10; i++) {
                btn[i] = new JButton(Integer.toString(i));
                btn[i].addActionListener(new MyActionListener());
                add(btn[i]);
            }

            JButton btn_ce = new JButton("CE");
            JButton btn_calc = new JButton("���");


            btn_ce.addActionListener(new MyActionListener());
            btn_calc.addActionListener(new MyActionListener());


            add(btn_ce);
            add(btn_calc);

        }
    }
    private class ThirdPanel extends JPanel{
        public ThirdPanel() {
            setLayout(new GridLayout(1,2,5,5));
            JButton btn_add = new JButton("+");
            JButton btn_sub = new JButton("-");

            btn_add.addActionListener(new MyActionListener());
            btn_sub.addActionListener(new MyActionListener());

            btn_add.setBackground(Color.CYAN);
            btn_sub.setBackground(Color.CYAN);

            add(btn_add);
            add(btn_sub);
        }
    }

    private class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton)e.getSource();

            int index = 0;
            // changeOperand �迭�� ������ Ȯ���ϱ� ���� ����� ����

            if(btn.getText().equals("CE")) {      // ���� ���õ� ��� ���� �ʱ�ȭ
                exprTextfield.setText("");
                resultTextfield.setText("");
                firstOperand = 0;
                secondOperand = 0;
            }
            else if(btn.getText().equals("���")) {
                String str = firstTextfield.getText();
                for(int i = firstTextfield.getText().length()-1; i >= 0; i--) {
                    char c = str.charAt(i);
                    // ù ��° �ؽ�Ʈ �ʵ忡 ����Ǿ� �ִ� ���ڸ� �ڿ��� ���� �ϳ��� �о����(�� ��° �ǿ����ڸ� ã�� ����)

                    if(c == '+' | c == '-' | c == 'x' | c == '/') {
                        operator = c;
                        break;
                    }
                    // �����ڸ� �������� ������ �ؽ�Ʈ�� �ǿ������̱� ������ �����ڸ� ã���� �� �̻� ������ �� �ʿ䰡 ����

                    else {
                        changeOperand[index] = Integer.parseInt(Character.toString(c));
                        secondOperand += changeOperand[index]*(Math.pow(10, index));
                        // ���� �Լ��� ����ؼ� �� ��° �ǿ����� ó��

                        index++;
                    }
                }

                switch(operator) {
                    case '+':
                        secondTextfield.setText(Float.toString(firstOperand + secondOperand));
                        break;
                    case '-':
                        secondTextfield.setText(Float.toString(firstOperand - secondOperand));
                        break;
                    case 'x':
                        secondTextfield.setText(Float.toString(firstOperand * secondOperand));
                        break;
                    case '/':
                        secondTextfield.setText(Float.toString(firstOperand / secondOperand));
                        break;
                }
            }

            else if(btn.getText().equals("+") | btn.getText().equals("-") | btn.getText().equals("x") | btn.getText().equals("/")) {
                // �ؽ�Ʈ �ʵ忡 �����ڰ� �ԷµǸ� ������ �ԷµǾ��� �ؽ�Ʈ���� ù ��° �ǿ����ڷ� firstOperand ������ ����

                firstOperand = Integer.parseInt(firstTextfield.getText());

                switch(btn.getText()) {
                    case "+":
                        firstTextfield.setText(firstTextfield.getText() + "+");
                        break;
                    case "-":
                        firstTextfield.setText(firstTextfield.getText() + "-");
                        break;
                    case "x":
                        firstTextfield.setText(firstTextfield.getText() + "x");
                        break;
                    case "/":
                        firstTextfield.setText(firstTextfield.getText() + "/");
                        break;
                }
            }

            else {
                for(int i = 0; i < 10; i++) {
                    if(btn.getText().equals(Integer.toString(i))) {
                        firstTextfield.setText(firstTextfield.getText() + Integer.toString(i));
                    }
                }
            }
        }
    }
}