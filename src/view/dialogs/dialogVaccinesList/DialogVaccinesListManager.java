package view.dialogs.dialogVaccinesList;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import view.main.mainPanels.PanelMainFooter;

public class DialogVaccinesListManager extends JDialog{

    public PanelMainFooter panelMainFooter;

    public PanelVaccinesListHeader panelVaccinesListHeader;
    public PanelVaccinesListFooter panelVaccinesListFooter;
    public PanelVaccinesListBody panelVaccinesListBody;

    public DialogVaccinesListManager(PanelMainFooter panelMainFooter) {
        super(panelMainFooter.mainView, true);
        this.panelMainFooter = panelMainFooter;
        initDialog();
        addPanels();
    }

    private void initDialog() {
        this.setTitle("Lista de vacunas");
        this.setSize(800, 600);
        this.setLocationRelativeTo(panelMainFooter.mainView);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
    }

    public void begin() {
        setVisible(true);
    }

    private void addHeader() {
        panelVaccinesListHeader = new PanelVaccinesListHeader();
        this.add(panelVaccinesListHeader, BorderLayout.NORTH);
    }

    private void addFooter() {
        panelVaccinesListFooter = new PanelVaccinesListFooter(this);
        this.add(panelVaccinesListFooter, BorderLayout.SOUTH);
    }

    private void addBody() {
        panelVaccinesListBody = new PanelVaccinesListBody(this);
        this.add(panelVaccinesListBody, BorderLayout.CENTER);
    }

    public void addPanels() {
        addHeader();
        addBody();
        addFooter();
    }
}
