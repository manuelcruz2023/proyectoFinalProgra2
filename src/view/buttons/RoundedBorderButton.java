package view.buttons;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class RoundedBorderButton extends AbstractBorder {
    private int radius;

    public RoundedBorderButton(int radius) {
        this.radius = radius;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.right = this.radius+1;
        insets.top = insets.bottom = this.radius+2;
        return insets;
    }
}
