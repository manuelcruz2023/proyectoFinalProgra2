package view.dialogs.dialogApplyVacine;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import view.GlobalConfigView;
import view.dialogs.configTextFieldView.ConfigLimitedTextField;

public class PanelApplyVacineBody extends JPanel {


    private DefaultTableModel defaultTableModel;
    private JTable table;
    private JScrollPane scrollPane;

    public PanelApplyVacineBody() {
        initPanel();
        begin();
        createLabelSearch();
        createTextField();
        createTable();
    }

    private void initPanel() {
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setFont(new Font("Roboto", Font.PLAIN, 18));
    }

    public void begin() {
        setVisible(true);
    }

    private void createLabelSearch() {
        JLabel search = new JLabel("Buscar por nombre:");
        search.setFont(getFont());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        //constraints.insets = new Insets(10, 0, 40, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(search, constraints);
    }

    private void createTextField() {
        ConfigLimitedTextField configLimitedTextField = new ConfigLimitedTextField(40);
        configLimitedTextField.setPreferredSize(new Dimension(300, 30));
        configLimitedTextField.setFont(getFont());
        configLimitedTextField.setToolTipText("Ingrese el nombre de la vacuna (maximo 40 caracteres)");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST; // Align to the left
        //constraints.insets = new Insets(10, 0, 40, 10);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(configLimitedTextField, constraints);
    }

    private void createTable() {
        defaultTableModel= new DefaultTableModel();
        defaultTableModel.addColumn("Nombre");
        defaultTableModel.addColumn("Especie de la mascota");
        defaultTableModel.addColumn("Fecha de vencimiento de la vacuna");
        defaultTableModel.addColumn("Duracion (en dias)"
        );
        table = new JTable(defaultTableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        add(scrollPane);
        defaultTableModel.addRow(new Object[]{"Juan Perez", "123456789",
            "Dueño", "Firulais", "Perro Macho", "12/12/2020"});
    }
}
