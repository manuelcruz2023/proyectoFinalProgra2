package view.dialogs.dialogWindowAddVaccine;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import view.GlobalConfigView;

public class PanelAddVaccineFooter extends JPanel {

    public PanelAddVaccineFooter() {
        initPanel();
        begin();
    }

    private void initPanel() {
        this.setPreferredSize(new Dimension(600, 60));
        this.setBackground(GlobalConfigView.FOOTER_BACKGROUND_COLOR);
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    private void begin() {
        this.setVisible(true);
    }
}
