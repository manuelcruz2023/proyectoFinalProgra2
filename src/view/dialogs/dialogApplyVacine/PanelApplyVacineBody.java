package view.dialogs.dialogApplyVacine;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.w3c.dom.events.MouseEvent;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseListener;

import view.GlobalConfigView;

public class PanelApplyVacineBody extends JPanel {

    public DialogApplyVacineManager dialogApplyVacineManager;
    private JTable table;
    private JScrollPane scrollPane;

    public PanelApplyVacineBody(DialogApplyVacineManager dialogApplyVacineManager) {
        this.dialogApplyVacineManager = dialogApplyVacineManager;
        initPanel();
        begin();
        createTable();
        addMouseListener();
    }

    private void initPanel() {
        this.setPreferredSize(new Dimension(600, 800));
        this.setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setFont(new Font("Roboto", Font.PLAIN, 18));
    }

    public void begin() {
        setVisible(true);
    }

    private void createTable() {
        if (dialogApplyVacineManager.panelAppointmentListBody.dialogAppointmentListManager.panelMainFooter.dialogVaccinesListManager == null) {
            dialogApplyVacineManager.panelAppointmentListBody.dialogAppointmentListManager.panelMainFooter
                    .createDialogVaccinesList();
        }
        scrollPane = dialogApplyVacineManager.panelAppointmentListBody.dialogAppointmentListManager.panelMainFooter.dialogVaccinesListManager.panelVaccinesListBody
                .getScrollPane();

        table = new JTable(
                dialogApplyVacineManager.panelAppointmentListBody.dialogAppointmentListManager.panelMainFooter.dialogVaccinesListManager.panelVaccinesListBody.table
                        .getModel());
        scrollPane.setPreferredSize(new Dimension(500, 700));
        scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private void addMouseListener() {
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    
                }
            }
        });
    }
    
}
