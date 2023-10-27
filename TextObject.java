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
        label.setFont(new Font(font.getName(), font.getStyle(), size));
        label.setForeground(color);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    // You can add more methods to customize the graphical object as needed.
}
