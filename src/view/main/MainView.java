package view.main;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import view.main.mainPanels.PanelMainBody;
import view.main.mainPanels.PanelMainFooter;
import view.main.mainPanels.PanelMainHeader;

public class MainView extends JFrame {

    public MainView() {
        initFrame();
        begin();
        createPanels();
    }
    
    private void initFrame() {
        setTitle("Main View");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
    }

    public void begin() {
        setVisible(true);
    }

    private void createHeader() {
        PanelMainHeader panelMainHeader = new PanelMainHeader();
        this.add(panelMainHeader, BorderLayout.NORTH);
    }

    private void createBody() {
        PanelMainBody panelMainBody = new PanelMainBody();
        this.add(panelMainBody, BorderLayout.CENTER);
    }

    private void createFooter() {
        PanelMainFooter panelMainFooter = new PanelMainFooter(this);
        this.add(panelMainFooter, BorderLayout.SOUTH);
    }

    private void createPanels() {
        createHeader();
        createBody();
        createFooter();
    }
}
