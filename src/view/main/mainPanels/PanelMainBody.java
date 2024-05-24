package view.main.mainPanels;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import view.GlobalConfigView;
import view.ImagePanel;

public class PanelMainBody extends JPanel {

    public PanelMainBody() {
        initPanel();
        begin();
        addBackgroundImage();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
        this.setForeground(GlobalConfigView.BODY_TEXT_COLOR);
        this.setLayout(new BorderLayout());
    }

    private void begin() {
        setVisible(true);
    }

    private void addBackgroundImage() {
        ImagePanel imagePanel = new ImagePanel("images\\BackgroundMainBody.png");
        this.add(imagePanel, BorderLayout.CENTER);
    }
}
