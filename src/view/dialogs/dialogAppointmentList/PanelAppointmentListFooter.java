package view.dialogs.dialogAppointmentList;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import view.GlobalConfigView;
import view.buttons.RoundedBorderButton;

public class PanelAppointmentListFooter extends JPanel{

    public PanelAppointmentListFooter() {
        initPanel();
        begin();
        createButtons();
    }

    private void initPanel() {
        this.setBackground(GlobalConfigView.FOOTER_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(800, 80));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 20));
    }

    public void begin() {
        setVisible(true);
    }

    private void createButtonFilterByDate() {
        JButton buttonFilterByDate = new JButton("Filtrar por fecha");
        buttonFilterByDate.setPreferredSize(new Dimension(150, 40));
        buttonFilterByDate.setBorder(new RoundedBorderButton(20));
        this.add(buttonFilterByDate);
    }

    private void createButtonFilterByResponsible () {
        JButton buttonFilterByResponsible = new JButton("Filtrar por responsable");
        buttonFilterByResponsible.setPreferredSize(new Dimension(200, 40));
        this.add(buttonFilterByResponsible);
    }

    private void createButtonFilterBySoonToExpire() {
        JButton buttonFilterBySoonToExpire = new JButton("Filtrar por proxima expiracion");
        buttonFilterBySoonToExpire.setPreferredSize(new Dimension(200, 40));
        this.add(buttonFilterBySoonToExpire);
    }

    private void createButtons() {
        createButtonFilterByDate();
        createButtonFilterByResponsible();
        createButtonFilterBySoonToExpire();
    }
}
