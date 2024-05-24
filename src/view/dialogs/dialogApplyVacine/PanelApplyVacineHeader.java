package view.dialogs.dialogApplyVacine;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import view.GlobalConfigView;

public class PanelApplyVacineHeader extends JPanel{

    public PanelApplyVacineHeader() {
        initPanel();
        begin();
        createTitle();
    }

    private void initPanel() {
        this.setPreferredSize(new Dimension(600, 100));
        this.setBackground(GlobalConfigView.HEADER_BACKGROUND_COLOR);
        this.setForeground(GlobalConfigView.HEADER_TEXT_COLOR);
        this.setFont(GlobalConfigView.TITLE_FONT);
    }

    public void begin() {
        setVisible(true);
    }

    private void createTitle() {
        JLabel title = new JLabel("Aplicar vacuna");
        title.setForeground(getForeground());
        title.setFont(getFont());
        this.add(title);
    }
}
