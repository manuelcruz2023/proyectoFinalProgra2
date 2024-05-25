package view.dialogs.dialogApplyVacine;

import javax.swing.JPanel;
import java.awt.Dimension;
import view.GlobalConfigView;

public class PanelApplyVacineFooter extends JPanel{

    public PanelApplyVacineFooter() {
        initPanel();
        begin();
    }

    private void initPanel() {
        this.setPreferredSize(new Dimension(600, 100));
        this.setBackground(GlobalConfigView.FOOTER_BACKGROUND_COLOR);
    }

    public void begin() {
        setVisible(true);
    }
    
}
