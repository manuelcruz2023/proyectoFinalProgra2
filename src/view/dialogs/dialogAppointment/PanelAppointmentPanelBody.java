package view.dialogs.dialogAppointment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pojos.Appointment;
import view.GlobalConfigView;
import view.dialogs.configTextFieldView.ConfigLimitedTextField;
import view.dialogs.configTextFieldView.ConfigTextFieldNumber;

public class PanelAppointmentPanelBody extends JPanel {

    public ConfigLimitedTextField textFieldCompleteName;
    public JComboBox<String> jComboBoxDocumentType;
    public ConfigTextFieldNumber textFieldNumber;
    public JComboBox<String> jComboBoxRelationship;
    public ConfigLimitedTextField textFieldPetName;
    public JComboBox<String> jComboBoxPetSpeciesAndSex;
    public ConfigTextFieldNumber textFieldWeight;
    public GridBagConstraints constraints;
    public Appointment appointment;

    public PanelAppointmentPanelBody() {
        initPanel();
        begin();
        createLabels();
        addTxtFields();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(800, 80));
        this.setFont(GlobalConfigView.BASIC_FONT);
        this.setLayout(new GridBagLayout());
        this.setFont(new Font("Roboto", Font.PLAIN, 18));
    }

    private void begin() {
        setVisible(true);
    }

    private void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(getFont());
        label.setSize(new Dimension(150, 30));
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.insets = new Insets(10, 0, 20, 0);
        constraints.gridx = x;
        constraints.gridy = y;
        add(label, constraints);
    }

    private void createLabels() {
        createLabel("Ingrese su nombre completo:", 0, 0);
        createLabel("Tipo de documento:", 0, 1);
        createLabel("Número de documento: ", 0, 2);
        createLabel("Relacion: ", 0, 3);
        createLabel("Nombre de la mascota: ", 0, 4);
        createLabel("Especie y sexo de la mascota: ", 0, 5);
        createLabel("Peso de la mascota: ", 0, 6);
    }

    // TxtFields

    private void createTextFieldCompleteName() {
        textFieldCompleteName = new ConfigLimitedTextField(50);
        textFieldCompleteName.setToolTipText("Máximo 50 caracteres");
        textFieldCompleteName.setFont(getFont());
        textFieldCompleteName.setBackground(Color.WHITE);
        textFieldCompleteName.setPreferredSize(new Dimension(400, 30));
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.gridx = 1; // Column 1
        constraints.gridy = 0; // Row 1
        this.add(textFieldCompleteName, constraints);
    }

    private void createJComboBoxDocumentType() {
        jComboBoxDocumentType = new JComboBox<>();
        jComboBoxDocumentType.addItem("C.C");
        jComboBoxDocumentType.addItem("C.E");
        jComboBoxDocumentType.addItem("T.I");
        jComboBoxDocumentType.setSelectedItem(null);
        jComboBoxDocumentType.setFont(getFont());
        jComboBoxDocumentType.setBackground(Color.WHITE);
        jComboBoxDocumentType.setPreferredSize(new Dimension(400, 30));
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.gridx = 1; // Column 1
        constraints.gridy = 1; // Row 2
        this.add(jComboBoxDocumentType, constraints);
    }

    private void createTextFieldDocumentNumber() {
        textFieldNumber = new ConfigTextFieldNumber();
        textFieldNumber.setText(null);
        textFieldNumber.setFont(getFont());
        textFieldNumber.setBackground(Color.WHITE);
        textFieldNumber.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        constraints.gridx = 1; // Column 1
        constraints.gridy = 2; // Row 3
        this.add(textFieldNumber, constraints);
    }

    private void createjComboBoxRelationship() {
        jComboBoxRelationship = new JComboBox<>();
        jComboBoxRelationship.addItem("Dueño");
        jComboBoxRelationship.addItem("Familiar");
        jComboBoxRelationship.addItem("Amigo");
        jComboBoxRelationship.setSelectedItem(null);
        jComboBoxRelationship.setFont(getFont());
        jComboBoxRelationship.setBackground(Color.WHITE);
        jComboBoxRelationship.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        constraints.gridx = 1; // Column 1
        constraints.gridy = 3; // Row 4
        this.add(jComboBoxRelationship, constraints);
    }

    private void createTextFieldPetName() {
        textFieldPetName = new ConfigLimitedTextField(30);
        textFieldPetName.setToolTipText("Máximo 30 caracteres");
        textFieldPetName.setFont(getFont());
        textFieldPetName.setBackground(Color.WHITE);
        textFieldPetName.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        constraints.gridx = 1; // Column 1
        constraints.gridy = 4; // Row 5
        this.add(textFieldPetName, constraints);
    }

    private void createTextFieldPetSpeciesAndSex() {
        jComboBoxPetSpeciesAndSex = new JComboBox<>();
        jComboBoxPetSpeciesAndSex.addItem("Perro");
        jComboBoxPetSpeciesAndSex.addItem("Gato");
        jComboBoxPetSpeciesAndSex.setSelectedItem(null);
        jComboBoxPetSpeciesAndSex.setFont(getFont());
        jComboBoxPetSpeciesAndSex.setBackground(Color.WHITE);
        jComboBoxPetSpeciesAndSex.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        constraints.gridx = 1; // Column 1
        constraints.gridy = 5; // Row 6
        this.add(jComboBoxPetSpeciesAndSex, constraints);
    }

    private void createFieldWeight() {
        textFieldWeight = new ConfigTextFieldNumber();
        textFieldWeight.setFont(getFont());
        textFieldWeight.setBackground(Color.WHITE);
        textFieldWeight.setPreferredSize(new Dimension(400, 30));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        constraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        constraints.gridx = 1; // Column 1
        constraints.gridy = 6; // Row 7
        this.add(textFieldWeight, constraints);
    }

    private void addTxtFields() {
        createTextFieldCompleteName();
        createJComboBoxDocumentType();
        createTextFieldDocumentNumber();
        createjComboBoxRelationship();
        createTextFieldPetName();
        createTextFieldPetSpeciesAndSex();
        createFieldWeight();
    }

    public boolean validateFields() {
        if (jComboBoxDocumentType.getSelectedItem() == null
                || textFieldNumber.getText().isEmpty() || jComboBoxRelationship.getSelectedItem() == null
                || textFieldPetName.getText().isEmpty() || jComboBoxPetSpeciesAndSex.getSelectedItem() == null || textFieldWeight.getText().isEmpty()){
            return false;
        }
        return true;
    }

    public Appointment createAppointment() {
        if (!validateFields()) {
            return null;
        }
        appointment = new Appointment();
        LocalDate date = LocalDate.now();
        appointment.setDate(date.toString());
        appointment.setCompletename(textFieldCompleteName.getText());
        appointment.setTypeDocument(jComboBoxDocumentType.getSelectedItem().toString());
        appointment.setDocumentNumber(textFieldNumber.getText());
        appointment.setRelationship(jComboBoxRelationship.getSelectedItem().toString());
        appointment.setPetName(textFieldPetName.getText());
        appointment.setPetType(jComboBoxPetSpeciesAndSex.getSelectedItem().toString());
        appointment.setWeight(textFieldWeight.getText().toString());
        return appointment;
    }
}
