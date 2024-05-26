package view.dialogs.dialogAddVaccine;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import view.GlobalConfigView;
import view.dialogs.dialogVaccinesList.PanelVaccinesListFooter;

public class DialogAddVaccineManager extends JDialog {

    public PanelVaccinesListFooter panelVaccinesListFooter;
    public PanelAddVaccineHeader panelAddVaccineHeader;
    public PanelAddVaccineBody panelAddVaccineBody;
    public PanelAddVaccineFooter panelAddVaccineFooter;

    public DialogAddVaccineManager(PanelVaccinesListFooter panelVaccinesListFooter) {
        super(panelVaccinesListFooter.dialogVaccinesListManager, true);
        this.panelVaccinesListFooter = panelVaccinesListFooter;
        initDialog();
        addPanels();
    }

    private void initDialog() {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(GlobalConfigView.BODY_BACKGROUND_COLOR);
        this.setLocationRelativeTo(panelVaccinesListFooter.dialogVaccinesListManager);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
    }

    public void begin() {
        setVisible(true);
    }

    private void createHeader() {
        panelAddVaccineHeader = new PanelAddVaccineHeader();
        this.add(panelAddVaccineHeader, BorderLayout.NORTH);
    }

    private void createBody() {
        panelAddVaccineBody = new PanelAddVaccineBody(this);
        this.add(panelAddVaccineBody, BorderLayout.CENTER);
    }

    private void createFooter() {
        panelAddVaccineFooter = new PanelAddVaccineFooter(this);
        this.add(panelAddVaccineFooter, BorderLayout.SOUTH);
    }

    private void addPanels() {
        createHeader();
        createBody();
        createFooter();
    }
}
