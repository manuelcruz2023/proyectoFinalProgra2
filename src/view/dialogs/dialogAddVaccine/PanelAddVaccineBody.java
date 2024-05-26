package view.dialogs.dialogAddVaccine;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import pojos.Vaccine;
import view.GlobalConfigView;
import view.dialogs.configTextFieldView.ConfigLimitedTextField;
import view.dialogs.configTextFieldView.ConfigTextFieldNumber;

public class PanelAddVaccineBody extends JPanel {

    public DialogAddVaccineManager dialogAddVaccineManager;

    public ConfigLimitedTextField textFieldVaccineName;
    public JComboBox<String> comboBoxSpecies;
    public ConfigTextFieldNumber textFieldDuration;
    public JDateChooser dateChooserExpiryDate;
    public GridBagConstraints constraints;
    public Vaccine vaccine;

    public PanelAddVaccineBody(
            DialogAddVaccineManager dialogAddVaccineManager) {
        this.dialogAddVaccineManager = dialogAddVaccineManager;
        initPanel();
        begin();
        createLabels();
        addTextFields();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
        this.setForeground(GlobalConfigView.BODY_TEXT_COLOR);
        this.setPreferredSize(new Dimension(600, 200));
        this.setLayout(new GridBagLayout());
        this.setFont(GlobalConfigView.BASIC_FONT);
    }

    private void begin() {
        this.setVisible(true);
    }

    private void createLabel(String text, int x, int y){
        JLabel label = new JLabel(text);
        label.setFont(getFont());
        label.setSize(new Dimension(150,30));
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.insets = new Insets(10, 0, 10, 10);
        constraints.gridx = x;
        constraints.gridy = y;
        add(label, constraints);
    }

    private void createLabels () {
        createLabel("Nombre de la vacuna:", 0, 0);
        createLabel("Para que especie es la vacuna?", 0, 1);
        createLabel("Fecha de caducidad:", 0, 2);
    }

    // TextFields

    private void createTextFieldVaccineName() {
        textFieldVaccineName = new ConfigLimitedTextField(50);
        textFieldVaccineName.setFont(new Font("Roboto", Font.PLAIN, 18));
        textFieldVaccineName.setPreferredSize(new Dimension(250, 30));
        textFieldVaccineName.setToolTipText("Nombre de la vacuna");
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        constraints.gridx = 1; // Column 1
        constraints.gridy = 0; // Row 0
        this.add(textFieldVaccineName, constraints);
    }

    private void createTextFieldSpecies() {
        comboBoxSpecies = new JComboBox<String>();
        comboBoxSpecies.addItem("Perro");
        comboBoxSpecies.addItem("Gato");
        comboBoxSpecies.setSelectedItem(null);
        comboBoxSpecies.setFont(new Font("Roboto", Font.PLAIN, 18));
        comboBoxSpecies.setPreferredSize(new Dimension(250, 30));
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        constraints.gridx = 1; // Column 1
        constraints.gridy = 1; // Row 1
        this.add(comboBoxSpecies, constraints);
    }

    private void createTextFieldExpiryDate() {
        dateChooserExpiryDate = new JDateChooser();
        dateChooserExpiryDate.setPreferredSize(new Dimension(250, 30));
    constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        constraints.gridx = 1; // Column 1
        constraints.gridy = 2; // Row 3
        this.add(dateChooserExpiryDate, constraints);
    }

    private void addTextFields() {
        createTextFieldVaccineName();
        createTextFieldSpecies();
        createTextFieldExpiryDate();
    }

    public Vaccine createVaccine() {
        vaccine = new Vaccine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        vaccine.setName(textFieldVaccineName.getText());
        vaccine.setSpecies(comboBoxSpecies.getSelectedItem().toString());
        vaccine.setExpiryDate(formatter.format(dateChooserExpiryDate.getDate()).toString());
        return vaccine;
    }
}
