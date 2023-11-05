import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TextObject {
    private String text;
    private Font font;
    private Color color;
    private int size;

    public TextObject(String text, Font font, Color color, int size) {
        this.text = text;
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public JLabel createLabel() {
        JLabel label = new JLabel(text);
        // Create a font
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        label.setFont(labelFont);
        label.setForeground(color);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
}
