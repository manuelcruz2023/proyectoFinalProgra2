package view.dialogs.dialogVaccinesList;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojos.Vaccine;
import view.GlobalConfigView;
import view.dialogs.dialogAddVaccine.DialogAddVaccineManager;

public class PanelVaccinesListBody extends JPanel {

    public DialogVaccinesListManager dialogVaccinesListManager;
    public DialogAddVaccineManager dialogAddVaccine;

    private DefaultTableModel defaultTableModel;
    public JTable table;
    private JScrollPane scrollPane;
    public List<Vaccine> vaccineList;

    public PanelVaccinesListBody(DialogVaccinesListManager dialogVaccinesListManager) {
        this.dialogVaccinesListManager = dialogVaccinesListManager;
        initPanel();
        begin();
        createTable();
        fillTableWithVaccines();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(800, 440));
    }

    public void begin() {
        setVisible(true);
    }

    public List<Vaccine> getListVaccines() {
        return dialogVaccinesListManager.panelMainFooter.mainView.getPresenter().loadListVaccine();
    }

    private void createTable() {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Nombre de la vacuna");
        defaultTableModel.addColumn("Especie");
        defaultTableModel.addColumn("Duracion (dias)");
        table = new JTable(defaultTableModel);
        scrollPane = new JScrollPane(table); // Agrega la tabla al JScrollPane
        scrollPane.setPreferredSize(new Dimension(700, 390));
        add(scrollPane);
    }

    public JScrollPane getScrollPane() {
        JTable newTable = new JTable(table.getModel());
        JScrollPane jScrollPane = new JScrollPane(newTable);
        return jScrollPane;
    }

    public void fillTableWithVaccines() {
        vaccineList = getListVaccines();
        defaultTableModel.setRowCount(0);
        for (Vaccine vaccine : vaccineList) {
            defaultTableModel.addRow(new Object[] {
                    vaccine.getName(),
                    vaccine.getSpecies(),
                    vaccine.getDuration()
            });
        }
    }
}
