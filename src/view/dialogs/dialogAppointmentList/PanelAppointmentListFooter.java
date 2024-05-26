package view.dialogs.dialogAppointmentList;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pojos.Appointment;
import view.GlobalConfigView;
import view.buttons.RoundedBorderButton;

public class PanelAppointmentListFooter extends JPanel{

    public DialogAppointmentListManager dialogAppointmentListManager;
    public List<Appointment> appointments;
    private DefaultTableModel defaultTableModel;
    private JTable table;
    public JScrollPane scrollPane;

    public PanelAppointmentListFooter(DialogAppointmentListManager dialogAppointmentListManager) {
        this.dialogAppointmentListManager = dialogAppointmentListManager;
        initPanel();
        begin();
        // createButtons();
        // createTable();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.FOOTER_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(800, 80));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 20));
    }

    public void begin() {
        setVisible(true);
    }

    // private void createButtonFilterByDate() {
    //     JButton buttonFilterByDate = new JButton("Filtrar por fecha");
    //     buttonFilterByDate.setPreferredSize(new Dimension(150, 40));
    //     buttonFilterByDate.setBorder(new RoundedBorderButton(20));
    //     buttonFilterByDate.addActionListener(new java.awt.event.ActionListener() {
    //         public void actionPerformed(java.awt.event.ActionEvent evt) {
    //             appointments = dialogAppointmentListManager.panelMainFooter.mainView.getPresenter()
    //             .loadFilterByDate();
    //             for (Appointment appointment : appointments) {
    //                 System.out.println(appointment.getDate());
    //             }
    //         }
    //     });
    //     this.add(buttonFilterByDate);
    // } 

    // private void createButtonFilterByResponsible () {
    //     JButton buttonFilterByResponsible = new JButton("Filtrar por responsable");
    //     buttonFilterByResponsible.setPreferredSize(new Dimension(200, 40));
    //     this.add(buttonFilterByResponsible);
    // }

    // private void createButtonFilterBySoonToExpire() {
    //     JButton buttonFilterBySoonToExpire = new JButton("Filtrar por proxima expiracion");
    //     buttonFilterBySoonToExpire.setPreferredSize(new Dimension(200, 40));
    //     this.add(buttonFilterBySoonToExpire);
    // }

    // private void createButtons() {
    //     createButtonFilterByDate();
    //     createButtonFilterByResponsible();
    //     createButtonFilterBySoonToExpire();
    // }
}
