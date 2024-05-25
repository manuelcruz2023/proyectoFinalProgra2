package view.dialogs.dialogAddVaccine;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.GlobalConfigView;

public class PanelAddVaccineHeader extends JPanel{
    
    public PanelAddVaccineHeader() {
        initPanel();
        begin();
        createTittle();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.HEADER_BACKGROUND_COLOR);
        this.setForeground(GlobalConfigView.HEADER_TEXT_COLOR);
        this.setPreferredSize(new Dimension(600, 60));
        this.setFont(GlobalConfigView.BASIC_FONT);
    }

    private void begin() {
        this.setVisible(true);
    }

    private void createTittle() {
        JLabel tittle = new JLabel("Agregar vacuna");
        tittle.setBounds(300, 0, 600, 200);
        tittle.setForeground(getForeground());
        tittle.setFont(getFont());
        this.add(tittle);
    }
}
