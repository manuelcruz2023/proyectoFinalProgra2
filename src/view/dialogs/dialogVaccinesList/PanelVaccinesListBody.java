package view.dialogs.dialogVaccinesList;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import view.GlobalConfigView;

public class PanelVaccinesListBody extends JPanel {

    public DialogVaccinesListManager dialogVaccinesListManager;
    public String[] columnNames;
    public String[][] data;
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

    public void createTable() {
        data = new String[0][4];
        columnNames = new String[] { "Nombre de la vacuna", "Especie",
                "Duracion (en dias)", "Fecha de vencimiento" };
        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(700, 365));
        scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }
}
