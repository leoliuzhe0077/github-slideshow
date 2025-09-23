import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneDialer implements ActionListener {
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonDash;
    private JButton buttonDial;

    private String phoneNumber = "";

    public PhoneDialer() {
        JFrame frame = new JFrame();
        frame.setTitle("Dialer");
        frame.setSize(200, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = (JPanel) frame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout());
        JLabel prompt = new JLabel("Enter the number to dial:");
        labelPanel.add(prompt);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4, 3, 5, 5));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonDash = new JButton("-");
        button0 = new JButton("0");

        gridPanel.add(button1);
        gridPanel.add(button2);
        gridPanel.add(button3);
        gridPanel.add(button4);
        gridPanel.add(button5);
        gridPanel.add(button6);
        gridPanel.add(button7);
        gridPanel.add(button8);
        gridPanel.add(button9);
        gridPanel.add(buttonDash);
        gridPanel.add(button0);
        gridPanel.add(new JLabel(""));

        content.add(labelPanel);
        content.add(gridPanel);

        buttonDial = new JButton("Dial Number");
        buttonDial.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(buttonDial);

        registerActionListeners();

        frame.setVisible(true);
    }

    private void registerActionListeners() {
        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonDash.addActionListener(this);
        buttonDial.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == buttonDial) {
            JOptionPane.showMessageDialog(null, phoneNumber.isEmpty() ? "" : phoneNumber);
            phoneNumber = "";
            return;
        } else if (source == button0) {
            phoneNumber += "0";
        } else if (source == button1) {
            phoneNumber += "1";
        } else if (source == button2) {
            phoneNumber += "2";
        } else if (source == button3) {
            phoneNumber += "3";
        } else if (source == button4) {
            phoneNumber += "4";
        } else if (source == button5) {
            phoneNumber += "5";
        } else if (source == button6) {
            phoneNumber += "6";
        } else if (source == button7) {
            phoneNumber += "7";
        } else if (source == button8) {
            phoneNumber += "8";
        } else if (source == button9) {
            phoneNumber += "9";
        } else if (source == buttonDash) {
            phoneNumber += "-";
        }
    }

    public static void main(String[] args) {
        new PhoneDialer();
    }
}
