import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    public CustomButton(String label, Color bgColor) {
        super(label); // Set the button label
        setBackground(bgColor); // Set the button's background color
        setForeground(Color.BLACK); // Set the text color (in this case, white)
        setFocusPainted(false); // Remove the default border

        // Define some additional styling
        setFont(new Font("Arial", Font.BOLD, 16)); // Set the font and size
        setBorderPainted(false); // Remove the border
        setOpaque(true); // Ensure that the button is opaque (background color is visible)

        // You can add more customization as needed, such as adding action listeners, tooltips, etc.
    }
}
