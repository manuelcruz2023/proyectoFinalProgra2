package view.dialogs.dialogAppointment;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pojos.Appointment;
import view.GlobalConfigView;
import view.buttons.RoundedBorderButton;

public class PanelAppointmentPanelFooter extends JPanel {

    public DialogAppointmentManager dialogAppointmentManager;

    public PanelAppointmentPanelFooter(DialogAppointmentManager dialogAppointmentManager) {
        this.dialogAppointmentManager = dialogAppointmentManager;
        initPanel();
        begin();
        createButtonSaveApointment();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.FOOTER_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(800, 80));
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    private void begin() {
        setVisible(true);
    }

    private void createButtonSaveApointment() {
        JButton buttonSaveApointment = new JButton("Guardar");
        buttonSaveApointment.setPreferredSize(new Dimension(100, 40));
        buttonSaveApointment.setBorder(new RoundedBorderButton(20));
        buttonSaveApointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (dialogAppointmentManager.panelAppointmentPanelBody.createAppointment() != null) {
                    if (dialogAppointmentManager.panelMainFooter.dialogAppointmentListManager == null) {
                        dialogAppointmentManager.panelMainFooter.createDialogAppointmentList();
                    }
                    // Crear y guardar la nueva cita
                    Appointment newAppointment = dialogAppointmentManager.panelAppointmentPanelBody.createAppointment();
                    dialogAppointmentManager.panelMainFooter.mainView.getPresenter().addAppointment(newAppointment);

                    // Actualizar la tabla
                    dialogAppointmentManager.panelMainFooter.dialogAppointmentListManager.panelAppointmentListBody
                            .fillTableWithAppointments();

                    dialogAppointmentManager.panelMainFooter.mainView.getPresenter().updateJson();
                    dialogAppointmentManager.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Campos incompletos",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.add(buttonSaveApointment);
    }
}
