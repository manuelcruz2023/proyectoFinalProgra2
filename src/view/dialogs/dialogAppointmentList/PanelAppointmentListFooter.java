package view.dialogs.dialogAppointmentList;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import pojos.Appointment;
import view.GlobalConfigView;

public class PanelAppointmentListFooter extends JPanel{

    public DialogAppointmentListManager dialogAppointmentListManager;
    public List<Appointment> appointments;
    public JScrollPane scrollPane;
    private JLabel labelInfo;

    public PanelAppointmentListFooter(DialogAppointmentListManager dialogAppointmentListManager) {
        this.dialogAppointmentListManager = dialogAppointmentListManager;
        initPanel();
        begin();
        labelInfo();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.FOOTER_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(800, 80));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 20));
    }

    public void begin() {
        setVisible(true);
    }

    public void labelInfo() {
        labelInfo = new JLabel("Para aplicar una vacuna, seleccione una cita, presione el click derecho y haga clic en 'Aplicar Vacuna'");
        labelInfo.setFont(GlobalConfigView.BASIC_FONT);
        labelInfo.setForeground(GlobalConfigView.FOOTER_TEXT_COLOR);
        this.add(labelInfo);
    }
}
