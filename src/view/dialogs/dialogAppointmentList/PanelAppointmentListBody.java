package view.dialogs.dialogAppointmentList;

import java.awt.Dimension;
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
        // this.setFont();
        initPanel();
        begin();
        createTable();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(800, 440));
    }

    public void begin() {
        setVisible(true);
    }

    private void createTable() {

        defaultTableModel= new DefaultTableModel();
        defaultTableModel.addColumn("Nombre completo del responsable");
        defaultTableModel.addColumn("Numero de documento del responsable");
        defaultTableModel.addColumn("Relacion");
        defaultTableModel.addColumn("Nombre de la mascota");
        defaultTableModel.addColumn("Especie y sexo de la mascota");
        defaultTableModel.addColumn("Fecha");
        defaultTableModel.addColumn("Dias restantes de la vacuna");
        table = new JTable(defaultTableModel);
        scrollPane= new JScrollPane(table);
        scrollPane.setBounds(0, 0, getWidth(),getHeight());
        add(scrollPane);
        addMouseListener();
    }

    public void addAppointment(Appointment appointment) {
        defaultTableModel.addRow(new Object[]{
            appointment.getCompletename(), 
            appointment.getDocumentNumber(),
            appointment.getRelationship(), 
            appointment.getPetName(),
            appointment.getPetTypeAndSex(),
            appointment.getDate()
        });
        
    }

    // public void addTable(Person responsible1){
    //     defaultTableModel.addRow(new Object[]{responsible1.getName(),responsible1.getLastName(),responsible1.getTypeDocument(),
    //         responsible1.getDocument(),responsible1.getPhoneNumber(),responsible1.getRelationship()});
    //     tablePet.revalidate();
    //     tablePet.repaint();
    //     scrollTable.revalidate();
    //     scrollTable.repaint();
    // }
    
    private void addMouseListener() {
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (SwingUtilities.isRightMouseButton(evt)) {
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
}
