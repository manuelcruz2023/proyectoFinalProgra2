package view.dialogs.dialogApplyVacine;

import javax.swing.JButton;
import javax.swing.JPanel;
import pojos.Vaccine;
import java.awt.Dimension;
import java.util.List;
import view.GlobalConfigView;
import view.buttons.RoundedBorderButton;

public class PanelApplyVacineFooter extends JPanel {

    public DialogApplyVacineManager dialogApplyVacineManager;
    private List<Vaccine> vaccinesList;
    public List<Vaccine> vaccinesApplied;

    public PanelApplyVacineFooter(DialogApplyVacineManager dialogApplyVacineManager) {
        this.dialogApplyVacineManager = dialogApplyVacineManager;
        initPanel();
        begin();
        getListVaccines();
        createButtonApplyVaccine();
    }

    private void initPanel() {
        this.setPreferredSize(new Dimension(600, 100));
        this.setBackground(GlobalConfigView.FOOTER_BACKGROUND_COLOR);
    }

    public void begin() {
        setVisible(true);
    }

    private List<Vaccine> getListVaccines() {
        vaccinesList = dialogApplyVacineManager.panelAppointmentListBody.dialogAppointmentListManager.panelMainFooter.dialogVaccinesListManager.panelVaccinesListBody
                .getListVaccines();
        return vaccinesList;
    }

    private void createButtonApplyVaccine() {
        JButton buttonSaveApointment = new JButton("Añadir Vacuna");
        buttonSaveApointment.setPreferredSize(new Dimension(150, 40));
        buttonSaveApointment.setBorder(new RoundedBorderButton(20));
        buttonSaveApointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        this.add(buttonSaveApointment);
    }
}
