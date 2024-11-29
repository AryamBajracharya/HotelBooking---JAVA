package hotelLuton;

import javax.swing.*; // import necessary classes
import java.awt.*;
import java.awt.event.*;

public class BarUI extends JFrame implements ActionListener { // Declare the class and implement the ActionListener interface

	//Declare instance variables
	
    private JLabel title, drinkLabel, snackLabel, priceLabel;
    private JComboBox<String> drinkCombo, snackCombo;
    private JButton orderButton;
    private JTextArea orderArea;
    private double drinkPrice, snackPrice, totalPrice;
    
    private String[] drinkList = {"Coca-Cola ($2.00)", "Pepsi ($2.00)", "Sprite ($2.00)", "Fanta ($2.00)", "Water ($1.00)", "Orange Juice ($3.00)", "Apple Juice ($3.00)", "Red Wine ($10.00)", "White Wine ($10.00)", "Beer ($5.00)", "Whiskey ($15.00)"};
    private String[] snackList = {"Chips ($2.00)", "Pretzels ($3.00)", "Nuts ($4.00)", "Popcorn ($5.00)", "Nachos ($6.00)", "Cheese Plate ($8.00)", "Fruit Plate ($7.00)"};

    public BarUI() {
        setTitle("Bar");
        setSize(500, 350);
        setLocationRelativeTo(null);

        // Create the components
        title = new JLabel("BAR");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.red);


        drinkLabel = new JLabel("Drink:");
        snackLabel = new JLabel("Snack:");
        priceLabel = new JLabel("Total Price: $0.00");

        drinkCombo = new JComboBox<>(drinkList);
        snackCombo = new JComboBox<>(snackList);

        orderButton = new JButton("Order");
        orderButton.addActionListener(this);

        orderArea = new JTextArea(10, 30);
        orderArea.setEditable(false);

        // Create the layout
        
        setLayout(null);
        title.setBounds(150, 10, 200, 30);
        drinkLabel.setBounds(50, 70, 50, 20);
        drinkCombo.setBounds(110, 70, 150, 20);
        snackLabel.setBounds(300, 70, 50, 20);
        snackCombo.setBounds(350, 70, 100, 20);
        orderButton.setBounds(350, 120, 100, 30);
        orderArea.setBounds(50, 160, 400, 120);
        priceLabel.setBounds(300, 290, 150, 20);
        add(title);
        add(drinkLabel);
        add(drinkCombo);
        add(snackLabel);
        add(snackCombo);
        add(orderButton);
        add(orderArea);
        add(priceLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderButton) {
            String drink = drinkCombo.getSelectedItem().toString();
            String snack = snackCombo.getSelectedItem().toString();
            String[] drinkParts = drink.split("\\D+");
            String[] snackParts = snack.split("\\D+");
            drinkPrice = Double.parseDouble(drinkParts[1]);
            snackPrice = Double.parseDouble(snackParts[1]);
            totalPrice = drinkPrice + snackPrice;
            String order = "You ordered:\n" + drink + "\n" + snack + "\nTotal Price: $" + String.format("%.2f", totalPrice) + "\n";
            orderArea.setText(order);
            priceLabel.setText("Total Price: $" + String.format("%.2f", totalPrice));
        }
        }
    
    public static void main(String[]args) {
    	new BarUI();
    }
   }






