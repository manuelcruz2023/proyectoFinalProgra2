package view.dialogs.dialogAppointmentList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import pojos.Appointment;
import pojos.Vaccine;
import view.GlobalConfigView;
import view.buttons.RoundedBorderButton;
import view.dialogs.dialogApplyVacine.DialogApplyVacineManager;

public class PanelAppointmentListBody extends JPanel {

    public DialogAppointmentListManager dialogAppointmentListManager;
    public DialogApplyVacineManager dialogApplyVacineManager;
    public List<Appointment> appointments;
    private DefaultTableModel defaultTableModel;
    private JTable table;
    public JScrollPane scrollPane;
    public int index;
    public List<Vaccine> vaccinesApplied;
    public int selection;
    private JPanel panelButtons;
    private JButton buttonFilterByDate;
    private JButton buttonFilterByResponsible;
    private JButton buttonFilterBySoonToExpire;
    private JButton buttonClearFilters;
    private String data;
    private JDateChooser dateChooser;

    public PanelAppointmentListBody(DialogAppointmentListManager dialogAppointmentListManager) {
        this.dialogAppointmentListManager = dialogAppointmentListManager;
        initPanel();
        begin();
        createTable();
        addMouseListener();
        createButtons();
        getRowSelected();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(1000, 440));
        this.setLayout(new BorderLayout());
    }

    public void begin() {
        setVisible(true);
    }

    public List<Appointment> getListAppointments() {
        switch (selection) {
            case 1:
                return dialogAppointmentListManager.panelMainFooter.mainView.getPresenter().loadFilterByDate();
            case 2:
                return dialogAppointmentListManager.panelMainFooter.mainView.getPresenter()
                        .loadFilterByResponsible(data);
            case 3:
                return dialogAppointmentListManager.panelMainFooter.mainView.getPresenter()
                        .loadFilterByVaccineSoonToExpire();
            case 0:
                return dialogAppointmentListManager.panelMainFooter.mainView.getPresenter().loadListAppointment();
            default:
                return null;
        }
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
        scrollPane.setPreferredSize(new Dimension(900, 390));
        add(scrollPane, BorderLayout.CENTER);
    }

    public void fillTableWithAppointments() {
        appointments = getListAppointments();
        defaultTableModel.setRowCount(0);
        for (Appointment appointment : appointments) {
            String vaccinesAppliedString = "";
            if (appointment.getVaccinesApplied() != null) {
                for (Vaccine vaccine : appointment.getVaccinesApplied()) {
                    vaccinesAppliedString += vaccine.getName() + ", ";
                }
            }
            defaultTableModel.addRow(new Object[] {
                    appointment.getCompletename(),
                    appointment.getDocumentNumber(),
                    appointment.getRelationship(),
                    appointment.getPetName(),
                    appointment.getPetTypeAndSex(),
                    appointment.getDate(),
                    vaccinesAppliedString
            });
        }
        selection = 0;

    }

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
        dialogApplyVacineManager = new DialogApplyVacineManager(this);
        dialogApplyVacineManager.begin();
    }

    private void createButtonFilterByDate() {
        buttonFilterByDate = new JButton("Filtrar por fecha");
        buttonFilterByDate.setPreferredSize(new Dimension(50, 50));
        buttonFilterByDate.setBorder(new RoundedBorderButton(20));
        buttonFilterByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection = 1;
                dateChooser = new JDateChooser();
                dateChooser.setPreferredSize(new Dimension(80, 20));
                JPanel panel = new JPanel();
                panel.add(dateChooser);
                JOptionPane.showConfirmDialog(null, panel, "Seleccione una fecha", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
                fillTableWithAppointments();
            }
        });
    }

    private void createButtonFilterByResponsible() {
        buttonFilterByResponsible = new JButton("Filtrar por responsable");
        buttonFilterByResponsible.setPreferredSize(new Dimension(200, 40));
        buttonFilterByResponsible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection = 2;
                data = JOptionPane.showInputDialog("Ingrese su numero de documento");
                System.out.println(data);
                fillTableWithAppointments();
            }
        });
    }

    private void createButtonFilterBySoonToExpire() {
        buttonFilterBySoonToExpire = new JButton("Filtrar por proxima expiracion");
        buttonFilterBySoonToExpire.setPreferredSize(new Dimension(200, 40));
        buttonFilterBySoonToExpire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection = 3;
                fillTableWithAppointments();
            }
        });
    }

    private void createButtonClearFilters() {
        buttonClearFilters = new JButton("Limpiar filtros");
        buttonClearFilters.setPreferredSize(new Dimension(100, 40));
        buttonClearFilters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection = 0;
                fillTableWithAppointments();
            }
        });
    }

    private void createButtons() {
        panelButtons = new JPanel(new GridLayout(4, 1));
        panelButtons.setPreferredSize(new Dimension(200, 440));
        createButtonFilterByDate();
        createButtonFilterByResponsible();
        createButtonFilterBySoonToExpire();
        createButtonClearFilters();
        panelButtons.add(buttonFilterByDate);
        panelButtons.add(buttonFilterByResponsible);
        panelButtons.add(buttonFilterBySoonToExpire);
        panelButtons.add(buttonClearFilters);
        this.add(panelButtons, BorderLayout.EAST);
    }

    public void getRowSelected() {
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                index = table.rowAtPoint(evt.getPoint());
            }
        });
    }
}