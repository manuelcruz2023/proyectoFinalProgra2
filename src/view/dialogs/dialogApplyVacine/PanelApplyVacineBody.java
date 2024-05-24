package view.dialogs.dialogApplyVacine;

import javax.swing.JPanel;
import java.awt.Dimension;
import view.GlobalConfigView;

public class PanelApplyVacineBody extends JPanel{

    public PanelApplyVacineBody() {
        initPanel();
        begin();
    }

    private void initPanel() {
        this.setPreferredSize(new Dimension(600, 200));
        this.setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
    }

    public void begin() {
        setVisible(true);
    }
}
