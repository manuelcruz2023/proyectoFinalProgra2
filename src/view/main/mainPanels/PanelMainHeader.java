package view.main.mainPanels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import view.GlobalConfigView;
import view.ImagePanel;

public class PanelMainHeader extends JPanel{
    public PanelMainHeader() {
        initPanel();
        begin();
        addLogo();
        addTittle();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.HEADER_BACKGROUND_COLOR);
        this.setForeground(GlobalConfigView.HEADER_TEXT_COLOR);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(800, 200));
    }

    private void begin() {
        setVisible(true);
    }

    private void addLogo() {
        ImagePanel logo = new ImagePanel("images\\logo.png");
        logo.setBounds(0, 0, 200, 200);
        this.add(logo, BorderLayout.WEST);
    }

    private void addTittle() {
        JLabel tittle = new JLabel("Cocovet");
        tittle.setBounds(300, 0, 600, 200);
        tittle.setForeground(getForeground());
        tittle.setFont(new Font("Poster Pen JNL", Font.BOLD, 140));
        this.add(tittle, BorderLayout.CENTER);
    }
}
