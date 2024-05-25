package view.dialogs.dialogAppointmentList;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import pojos.Appointment;
import view.GlobalConfigView;
import view.dialogs.dialogApplyVacine.DialogApplyVacineManager;

public class PanelAppointmentListBody extends JPanel {

    public DialogAppointmentListManager dialogAppointmentListManager;

    private DefaultTableModel defaultTableModel;
    private JTable table;
    public JScrollPane scrollPane;

    public PanelAppointmentListBody(DialogAppointmentListManager dialogAppointmentListManager) {
        this.dialogAppointmentListManager = dialogAppointmentListManager;
        initPanel();
        begin();
        createTable();
        addMouseListener();
        fillTableWithAppointments();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(800, 440));
    }

    public void begin() {
        setVisible(true);
    }

    private List<Appointment> getListAppointments() {
        return dialogAppointmentListManager.panelMainFooter.mainView.getPresenter().loadListAppointment();
    }

    private void createTable() {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Nombre completo del responsable");
        defaultTableModel.addColumn("Numero de documento del responsable");
        defaultTableModel.addColumn("Relacion");
        defaultTableModel.addColumn("Nombre de la mascota");
        defaultTableModel.addColumn("Especie y sexo de la mascota");
        defaultTableModel.addColumn("Fecha");
        defaultTableModel.addColumn("Vacunas aplicadas");
        table = new JTable(defaultTableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        add(scrollPane);
    }

    public void fillTableWithAppointments() {
        List<Appointment> appointments = getListAppointments();
        defaultTableModel.setRowCount(0);
        for (Appointment appointment : appointments) {
            defaultTableModel.addRow(new Object[] {
                    appointment.getCompletename(),
                    appointment.getDocumentNumber(),
                    appointment.getRelationship(),
                    appointment.getPetName(),
                    appointment.getPetTypeAndSex(),
                    appointment.getDate(),
                    appointment.getVaccinesApplied()
            });
        }
    }

    private void addMouseListener() {
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (SwingUtilities.isRightMouseButton(evt)) {
                    System.out.println("Right click");
                    createPopupMenu();
                }
            }
        });
    }

    private void createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("Aplicar vacuna");
        menuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDialogApplyVacine();
            }
        });
        JMenuItem menuItem2 = new JMenuItem("Eliminar cita");
        popupMenu.setPreferredSize(new Dimension(100, 50));
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        table.setComponentPopupMenu(popupMenu);
    }

    private void createDialogApplyVacine() {
        DialogApplyVacineManager dialogApplyVacineManager = new DialogApplyVacineManager(this);
        dialogApplyVacineManager.begin();
    }

    public void removeAppointment() {
        int row = table.getSelectedRow();
        if (row != -1) {
            defaultTableModel.removeRow(row);
        }
    }
}