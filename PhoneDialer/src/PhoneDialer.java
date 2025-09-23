import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneDialer implements ActionListener {

	// Digit buttons 0-9
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

	// Dash button and Dial button
	private JButton buttonDash;
	private JButton buttonDial;

	// Internal phone number string being built by the user
	private String phoneNumber = "";

	public static void main(String[] args) {
		// Create an instance of the dialer to show the UI
		SwingUtilities.invokeLater(() -> new PhoneDialer());
	}

	public PhoneDialer() {
		// Create main application frame
		JFrame frame = new JFrame("Dialer");
		frame.setSize(200, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel content = (JPanel) frame.getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Top label panel
		JPanel labelPanel = new JPanel(new FlowLayout());
		JLabel promptLabel = new JLabel("Enter the number to dial:");
		labelPanel.add(promptLabel);

		// Grid for keypad: 4 rows x 3 columns with 5px gaps
		JPanel keypadPanel = new JPanel(new GridLayout(4, 3, 5, 5));
		keypadPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		// Create digit buttons and dash
		button1 = createKeyButton("1");
		button2 = createKeyButton("2");
		button3 = createKeyButton("3");
		button4 = createKeyButton("4");
		button5 = createKeyButton("5");
		button6 = createKeyButton("6");
		button7 = createKeyButton("7");
		button8 = createKeyButton("8");
		button9 = createKeyButton("9");
		buttonDash = createKeyButton("-");
		button0 = createKeyButton("0");

		// Arrange buttons as a standard keypad with dash and zero on the last row
		keypadPanel.add(button1);
		keypadPanel.add(button2);
		keypadPanel.add(button3);
		keypadPanel.add(button4);
		keypadPanel.add(button5);
		keypadPanel.add(button6);
		keypadPanel.add(button7);
		keypadPanel.add(button8);
		keypadPanel.add(button9);
		keypadPanel.add(buttonDash);
		keypadPanel.add(button0);
		// Leave the last grid cell empty to complete the 4x3 layout

		// Dial button centered under the keypad
		buttonDial = new JButton("Dial Number");
		buttonDial.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonDial.addActionListener(this);

		// Assemble content
		content.add(labelPanel);
		content.add(keypadPanel);
		content.add(buttonDial);

		frame.setVisible(true);
	}

	private JButton createKeyButton(String label) {
		JButton button = new JButton(label);
		button.addActionListener(this);
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == buttonDial) {
			// Show the dialed number and reset for the next attempt
			JOptionPane.showMessageDialog(null, phoneNumber.isEmpty() ? "(no digits entered)" : phoneNumber,
					"Dialing", JOptionPane.INFORMATION_MESSAGE);
			phoneNumber = "";
			return;
		}

		// Handle keypad input by appending the corresponding character
		if (source == button0) {
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
}

