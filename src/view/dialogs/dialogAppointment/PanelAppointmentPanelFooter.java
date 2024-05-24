package view.dialogs.dialogAppointment;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
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
        // buttonSaveApointment.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         if (dialogAppointmentManager.panelMainFooter.dialogAppointmentListManager != null) {
        //             dialogAppointmentManager.panelMainFooter.dialogAppointmentListManager.panelAppointmentListBody.addRows(createPerson());
        //         }
        //         else{
        //             dialogAppointmentManager.panelMainFooter.createDialogAppointmentList();
        //         }
        //     }
        // });
        this.add(buttonSaveApointment);
    }

    // public Appointment createPerson() {
    //     Appointment person = new Appointment();
    //     person.setDate(dialogAppointmentManager.panelAppointmentPanelBody.jDateChooser.getCalendar());
    //     person.setCompletename(dialogAppointmentManager.panelAppointmentPanelBody.textFieldCompleteName.getText());
    //     person.setTypeDocument(
    //             dialogAppointmentManager.panelAppointmentPanelBody.jComboBoxDocumentType.getSelectedItem().toString());
    //     person.setDocumentNumber(dialogAppointmentManager.panelAppointmentPanelBody.textFieldNumber.getText());
    //     person.setRelationship(
    //             dialogAppointmentManager.panelAppointmentPanelBody.jComboBoxRelationship.getSelectedItem().toString());
    //     person.setPetTypeAndSex(dialogAppointmentManager.panelAppointmentPanelBody.jComboBoxPetSpeciesAndSex
    //             .getSelectedItem().toString());
    //     return person;
    // }
}
