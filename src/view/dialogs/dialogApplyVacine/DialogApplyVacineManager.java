package view.dialogs.dialogApplyVacine;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import view.dialogs.dialogAppointmentList.PanelAppointmentListBody;

public class DialogApplyVacineManager extends JDialog{

    public PanelAppointmentListBody panelAppointmentListBody;

    public PanelApplyVacineHeader panelApplyVacineHeader;
    public PanelApplyVacineBody panelApplyVacineBody;
    public PanelApplyVacineFooter panelApplyVacineFooter;

    public DialogApplyVacineManager(PanelAppointmentListBody panelAppointmentListBody) {
        super(panelAppointmentListBody.dialogAppointmentListManager, true);
        this.panelAppointmentListBody = panelAppointmentListBody;
        initDialog();
        addComponents();
    }

    private void initDialog() {
        this.setSize(600,400);
        this.setLocationRelativeTo(panelAppointmentListBody.dialogAppointmentListManager);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
    }

    public void begin() {
        setVisible(true);
    }

    private void createHeader() {
        panelApplyVacineHeader = new PanelApplyVacineHeader();
        this.add(panelApplyVacineHeader, BorderLayout.NORTH);
    }

    private void createBody() {
        panelApplyVacineBody = new PanelApplyVacineBody();
        this.add(panelApplyVacineBody, BorderLayout.CENTER);
    }

    private void createFooter() {
        panelApplyVacineFooter = new PanelApplyVacineFooter();
        this.add(panelApplyVacineFooter, BorderLayout.SOUTH);
    }

    public void addComponents() {
        createHeader();
        createBody();
        createFooter();
    }
}
