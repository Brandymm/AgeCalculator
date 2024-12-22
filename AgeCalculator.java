import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;


public class AgeCalculator extends JFrame {
	
	private JTextField birthDateField;
	private JButton calculateButton;
	private JLabel resultLabel;
	
	public AgeCalculator() {
		// Set up the JFrame
		setTitle("Age Calculator");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Create JPanel and set Layout
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		// Create components
		JLabel birthDateLabel = new JLabel("Enter Birth Date (YYYY-MM-DD): ");
		birthDateField = new JTextField(10);
		calculateButton = new JButton("Calculate Age:");
		resultLabel = new JLabel("Your age will be displayed here.");
		
		// Add components to the panel
		panel.add(birthDateLabel);
		panel.add(birthDateField);
		panel.add(calculateButton);
		panel.add(resultLabel);
		
		// Add ActionListener to the button
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculateAge();
			}
			
		});
		
		// Add the panel to the frame
		add(panel);
	}
	
	private void calculateAge() {
		// Get birth date from the text field
		String birthDateText = birthDateField.getText();
		
		try {
			// Parse the birth date
			LocalDate birthDate = LocalDate.parse(birthDateText);
			LocalDate currentDate = LocalDate.now();
			
			// Calculate the age
			Period period = Period.between(birthDate, currentDate);
			int age = period.getYears();
			
			// Display the result in the result label
			resultLabel.setText("Your age: " + age);
		} catch (Exception e) {
			// Handle invalid input format
			resultLabel.setText("Invalid date format. Please use YYYY-MM-DD.");
		}
	}
	
	public static void main(String[] args) {
		// Run the GUI application
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new AgeCalculator().setVisible(true);
			}
		});
	}

}
