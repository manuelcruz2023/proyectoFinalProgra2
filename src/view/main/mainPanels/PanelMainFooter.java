package view.main.mainPanels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import view.GlobalConfigView;
import view.buttons.RoundButton;
import view.dialogs.dialogAppointment.DialogAppointmentManager;
import view.dialogs.dialogAppointmentList.DialogAppointmentListManager;
import view.dialogs.dialogVaccinesList.DialogVaccinesListManager;
import view.main.MainView;

public class PanelMainFooter extends JPanel {

    public MainView mainView;

    public DialogAppointmentManager dialogAppointmentManager;
    public DialogVaccinesListManager dialogVaccinesListManager;
    public DialogAppointmentListManager dialogAppointmentListManager;

    public PanelMainFooter(MainView mainView) {
        this.mainView = mainView;
        initPanel();
        addButtons();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.FOOTER_BACKGROUND_COLOR);
        this.setForeground(GlobalConfigView.FOOTER_TEXT_COLOR);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 0));
        this.setPreferredSize(new Dimension(800, 200));
    }

    private void addAppointmentButton() {
        RoundButton roundButton = new RoundButton("Agregar cita");
        roundButton.setBackground(GlobalConfigView.BUTTON_BACKGROUND_COLOR);
        roundButton.setForeground(GlobalConfigView.BUTTON_TEXT_COLOR);
        roundButton.setPreferredSize(new Dimension(200, 200));
        roundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDialogAppointment();
            }
        });
        this.add(roundButton);
    }

    private void addListVaccinesButton() {
        RoundButton roundButton = new RoundButton("Lista de vacunas");
        roundButton.setBackground(GlobalConfigView.BUTTON_BACKGROUND_COLOR);
        roundButton.setForeground(GlobalConfigView.BUTTON_TEXT_COLOR);
        roundButton.setPreferredSize(new Dimension(200, 200));
        roundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDialogVaccinesList();
            }
        });
        this.add(roundButton);
    }

    private void addAppointmentListButton() {
        RoundButton roundButton = new RoundButton("Lista de  citas");
        roundButton.setBackground(GlobalConfigView.BUTTON_BACKGROUND_COLOR);
        roundButton.setForeground(GlobalConfigView.BUTTON_TEXT_COLOR);
        roundButton.setPreferredSize(new Dimension(200, 200));
        roundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDialogAppointmentList();
                beginDialogAppointmentList();
            }
        });
        this.add(roundButton);
    }

    private void addButtons() {
        addAppointmentButton();
        addListVaccinesButton();
        addAppointmentListButton();
    }

    private void createDialogAppointment() {
        if (dialogAppointmentManager == null) {
            dialogAppointmentManager = new DialogAppointmentManager(this);
        }
        dialogAppointmentManager.begin();
    }

    public void createDialogVaccinesList() {
        if (dialogVaccinesListManager == null) {
            dialogVaccinesListManager = new DialogVaccinesListManager(this);
        }
        dialogVaccinesListManager.begin();
    }

    public void createDialogAppointmentList() {
        if (dialogAppointmentListManager == null) {
            dialogAppointmentListManager = new DialogAppointmentListManager(this);
        }
        //dialogAppointmentListManager.begin();
    }

    public void beginDialogAppointmentList() {
        dialogAppointmentListManager.begin();
    }
}
