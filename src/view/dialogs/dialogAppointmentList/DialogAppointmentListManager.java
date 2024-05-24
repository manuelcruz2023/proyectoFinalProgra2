package view.dialogs.dialogAppointmentList;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import view.main.mainPanels.PanelMainFooter;

public class DialogAppointmentListManager extends JDialog {

    public PanelMainFooter panelMainFooter;

    public PanelAppointmentListHeader panelAppointmentListHeader;
    public PanelAppointmentListFooter panelAppointmentListFooter;
    public PanelAppointmentListBody panelAppointmentListBody;

    public DialogAppointmentListManager(PanelMainFooter panelMainFooter) {
        super(panelMainFooter.mainView, true);
        this.panelMainFooter = panelMainFooter;
        initDialog();
        addPanels();
    }

    private void initDialog() {
        this.setTitle("Lista de citas");
        this.setSize(800, 600);
        this.setLocationRelativeTo(panelMainFooter.mainView);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
    }

    public void begin() {
        setVisible(true);
    }

    private void addHeader() {
        panelAppointmentListHeader = new PanelAppointmentListHeader();
        this.add(panelAppointmentListHeader, BorderLayout.NORTH);
    }

    private void addFooter() {
        panelAppointmentListFooter = new PanelAppointmentListFooter();
        this.add(panelAppointmentListFooter, BorderLayout.SOUTH);
    }

    private void addBody() {
        panelAppointmentListBody = new PanelAppointmentListBody(this);
        this.add(panelAppointmentListBody, BorderLayout.CENTER);
    }

    public void addPanels() {
        addHeader();
        addBody();
        addFooter();
    }
}
