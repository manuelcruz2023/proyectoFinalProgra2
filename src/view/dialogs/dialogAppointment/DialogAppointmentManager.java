package view.dialogs.dialogAppointment;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        clear();
    }

    private void initDialog() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(panelMainFooter.mainView);
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

    private void clear() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                panelAppointmentPanelBody.textFieldCompleteName.setText("");
                panelAppointmentPanelBody.textFieldNumber.setText("");
                panelAppointmentPanelBody.textFieldPetName.setText("");
                panelAppointmentPanelBody.jComboBoxDocumentType.setSelectedItem(null);
                panelAppointmentPanelBody.jComboBoxRelationship.setSelectedItem(null);
                panelAppointmentPanelBody.jComboBoxPetSpeciesAndSex.setSelectedItem(null);
            }
        });
        this.dispose();
    }
}
