package view.main;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;

import interfaces.Contract;
import pojos.Appointment;
import pojos.Vaccine;
import view.main.mainPanels.PanelMainBody;
import view.main.mainPanels.PanelMainFooter;
import view.main.mainPanels.PanelMainHeader;

public class MainView extends JFrame implements Contract.View {

    private Contract.Presenter presenter;

    public MainView() {
        initFrame();
        begin();
        createPanels();
    }

    private void initFrame() {
        setTitle("Main View");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setResizable(false);
    }

    public void begin() {
        setVisible(true);
    }

    private void createHeader() {
        PanelMainHeader panelMainHeader = new PanelMainHeader();
        this.add(panelMainHeader, BorderLayout.NORTH);
    }

    private void createBody() {
        PanelMainBody panelMainBody = new PanelMainBody();
        this.add(panelMainBody, BorderLayout.CENTER);
    }

    private void createFooter() {
        PanelMainFooter panelMainFooter = new PanelMainFooter(this);
        this.add(panelMainFooter, BorderLayout.SOUTH);
    }

    private void createPanels() {
        createHeader();
        createBody();
        createFooter();
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    public Contract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public List<Appointment> requestListAppointment() {
        return presenter.loadListAppointment();
    }
}
