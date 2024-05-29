package view.dialogs.dialogApplyVacine;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pojos.Vaccine;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import view.GlobalConfigView;
import view.buttons.RoundedBorderButton;

public class PanelApplyVacineFooter extends JPanel {

    public DialogApplyVacineManager dialogApplyVacineManager;
    private List<Vaccine> vaccinesList;

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
        JButton buttonApplyVaccine = new JButton("Aplicar Vacuna");
        buttonApplyVaccine.setPreferredSize(new Dimension(150, 40));
        buttonApplyVaccine.setBorder(new RoundedBorderButton(20));
        buttonApplyVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                List<Vaccine> vaccinesApplied; // Declare vaccinesApplied variable
                if (dialogApplyVacineManager.panelAppointmentListBody.appointments
                        .get(dialogApplyVacineManager.panelAppointmentListBody.index).getVaccinesApplied() == null) {
                    vaccinesApplied = new ArrayList<>(); // Initialize vaccinesApplied
                } else {
                    vaccinesApplied = dialogApplyVacineManager.panelAppointmentListBody.appointments
                            .get(dialogApplyVacineManager.panelAppointmentListBody.index)
                            .getVaccinesApplied(); // Assign existing vaccinesApplied
                }

                Vaccine selectedVaccine = dialogApplyVacineManager.panelAppointmentListBody.dialogAppointmentListManager.panelMainFooter.dialogVaccinesListManager.panelVaccinesListBody.vaccineList
                        .get(dialogApplyVacineManager.panelApplyVacineBody.index); // Get selected vaccine

                String petType = dialogApplyVacineManager.panelAppointmentListBody.appointments
                        .get(dialogApplyVacineManager.panelAppointmentListBody.index).getPetType(); // Get pet type

                if ((petType.equals("Perro") && selectedVaccine.getSpecies().equals("Gato")) ||
                        (petType.equals("Gato") && selectedVaccine.getSpecies().equals("Perro"))) {
                    // Show error message
                    JOptionPane.showMessageDialog(null,
                            "No puede aplicar una vacuna para " + selectedVaccine.getSpecies() + " a un " + petType);
                    return;
                }

                vaccinesApplied.add(selectedVaccine); // Add vaccine to vaccinesApplied
                dialogApplyVacineManager.panelAppointmentListBody.appointments
                        .get(dialogApplyVacineManager.panelAppointmentListBody.index)
                        .setVaccinesApplied(vaccinesApplied); // Set vaccinesApplied
                dialogApplyVacineManager.panelAppointmentListBody.fillTableWithAppointments(); // Fill table with
                                                                                               // appointments
                dialogApplyVacineManager.panelAppointmentListBody.dialogAppointmentListManager.panelMainFooter.mainView
                        .getPresenter().updateJsonAppointments();
                ;
                dialogApplyVacineManager.dispose();
            }
        });
        this.add(buttonApplyVaccine);
    }
}
