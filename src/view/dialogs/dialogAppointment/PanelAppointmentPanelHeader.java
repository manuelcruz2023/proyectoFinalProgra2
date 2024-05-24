package view.dialogs.dialogAppointment;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.GlobalConfigView;

public class PanelAppointmentPanelHeader extends JPanel{

    public PanelAppointmentPanelHeader() {
        initPanel();
        begin();
        createTittle();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.HEADER_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(800, 80));
        this.setForeground(GlobalConfigView.HEADER_TEXT_COLOR);
    }

    private void begin() {
        setVisible(true);
    }

    private void createTittle() {
        JLabel tittle = new JLabel("Agregar cita");
        tittle.setBounds(300, 0, 600, 200);
        tittle.setForeground(getForeground());
        tittle.setFont(new Font("Poster Pen JNL", Font.BOLD, 60));
        this.add(tittle);
    }
}
