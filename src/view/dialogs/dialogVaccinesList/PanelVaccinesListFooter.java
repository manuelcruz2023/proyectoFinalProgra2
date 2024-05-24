package view.dialogs.dialogVaccinesList;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import view.GlobalConfigView;
import view.buttons.RoundedBorderButton;
import view.dialogs.dialogWindowAddVaccine.DialogAddVaccineManager;

public class PanelVaccinesListFooter extends JPanel{

    public DialogVaccinesListManager dialogVaccinesListManager;

    public PanelVaccinesListFooter(DialogVaccinesListManager dialogVaccinesListManager) {
        this.dialogVaccinesListManager = dialogVaccinesListManager;
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
        JButton buttonSaveApointment = new JButton("Añadir Vacuna");
        buttonSaveApointment.setPreferredSize(new Dimension(150, 40));
        buttonSaveApointment.setBorder(new RoundedBorderButton(20));
        buttonSaveApointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDialogAddVaccine();
            }
        });
        this.add(buttonSaveApointment);
    }

    private void createDialogAddVaccine() {
        DialogAddVaccineManager emergentWindowAddVaccine = new DialogAddVaccineManager(this);
        emergentWindowAddVaccine.begin();
    }
}
