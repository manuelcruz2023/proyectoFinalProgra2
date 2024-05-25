package view.dialogs.dialogVaccinesList;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pojos.Vaccine;
import view.GlobalConfigView;

public class PanelVaccinesListBody extends JPanel {

    public DialogVaccinesListManager dialogVaccinesListManager;
    public DefaultTableModel defaultTableModel;
    public JTable table;
    public JScrollPane scrollPane;

    public PanelVaccinesListBody(DialogVaccinesListManager dialogVaccinesListManager) {
        this.dialogVaccinesListManager = dialogVaccinesListManager;
        initPanel();
        begin();
        createTable();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(800, 440));
    }

    private void begin() {
        setVisible(true);
    }

    private void createTable() {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Nombre de la vacuna");
        defaultTableModel.addColumn("Especie");
        defaultTableModel.addColumn("Duracion (en dias)");
        defaultTableModel.addColumn("Fecha de vencimiento");
        table = new JTable(defaultTableModel);
        scrollPane = new JScrollPane();
        add(scrollPane);
    }

    public void addVaccine(Vaccine vaccine) {
        defaultTableModel.addRow(new Object[]{
            vaccine.getName(),
            vaccine.getSpecies(),
            vaccine.getDuration(),
            vaccine.getExpiryDate()
        });
    }
}
