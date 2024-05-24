package view;

import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
    private Image image;

    public ImagePanel(String imgPath) {
        image = new ImageIcon(imgPath).getImage();
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
