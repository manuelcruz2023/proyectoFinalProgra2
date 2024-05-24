package view.dialogs.dialogAppointment;

import java.awt.BorderLayout;
import javax.swing.JDialog;

import view.main.mainPanels.PanelMainFooter;

public class DialogAppointmentManager extends JDialog {

    public PanelMainFooter panelMainFooter;

    public PanelAppointmentPanelHeader panelAppointmentPanelHeader;
    public PanelAppointmentPanelFooter panelAppointmentPanelFooter;
    public PanelAppointmentPanelBody panelAppointmentPanelBody;

    public DialogAppointmentManager(PanelMainFooter panelMainFooter) {
        super(panelMainFooter.mainView, true);
        this.panelMainFooter = panelMainFooter;
        initDialog();
        addPanels();
    }

    private void initDialog() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(panelMainFooter.mainView);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
    }

    public void begin() {
        this.setVisible(true);
    }

    public void addHeader() {
        panelAppointmentPanelHeader = new PanelAppointmentPanelHeader();
        this.add(panelAppointmentPanelHeader, BorderLayout.NORTH);
    }

    public void addFooter() {
        panelAppointmentPanelFooter = new PanelAppointmentPanelFooter(this);
        this.add(panelAppointmentPanelFooter, BorderLayout.SOUTH);
    }

    public void addBody() {
        panelAppointmentPanelBody = new PanelAppointmentPanelBody();
        this.add(panelAppointmentPanelBody, BorderLayout.CENTER);
    }

    public void addPanels() {
        addHeader();
        addBody();
        addFooter();
    }
}
