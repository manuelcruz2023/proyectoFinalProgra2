package view.dialogs.dialogAddVaccine;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.GlobalConfigView;
import view.buttons.RoundedBorderButton;

public class PanelAddVaccineFooter extends JPanel {

    public DialogAddVaccineManager dialogAddVaccineManager;

    public PanelAddVaccineFooter(DialogAddVaccineManager dialogAddVaccineManager) {
        this.dialogAddVaccineManager = dialogAddVaccineManager;
        initPanel();
        begin();
        createButtonSaveVaccine();
    }

    private void initPanel() {
        this.setPreferredSize(new Dimension(600, 60));
        this.setBackground(GlobalConfigView.FOOTER_BACKGROUND_COLOR);
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    private void begin() {
        this.setVisible(true);
    }

    private void createButtonSaveVaccine() {
        JButton buttonSaveVaccine = new JButton("Guardar");
        buttonSaveVaccine.setPreferredSize(new Dimension(100, 40));
        buttonSaveVaccine.setBorder(new RoundedBorderButton(20));
        buttonSaveVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (dialogAddVaccineManager.panelAddVaccineBody.createVaccine() != null) {
                    // Crear y guardar la nueva vacuna
                dialogAddVaccineManager.panelVaccinesListFooter.dialogVaccinesListManager.
                panelMainFooter.mainView.getPresenter().
                addVaccine(dialogAddVaccineManager.panelAddVaccineBody.createVaccine());

                // Actualizar la tabla
                dialogAddVaccineManager.panelVaccinesListFooter.dialogVaccinesListManager.
                panelMainFooter.dialogVaccinesListManager.panelVaccinesListBody.
                fillTableWithVaccines();
                dialogAddVaccineManager.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.add(buttonSaveVaccine);
    }
}
