package presenter;

import java.util.List;
import interfaces.Contract;
import pojos.Appointment;
import pojos.Vaccine;

public class Presenter implements Contract.Presenter{

    private Contract.Model model;
    private Contract.View view;
    
    @Override
    public void setModel(Contract.Model model) {
        this.model = model;
    }
    
    @Override
    public void setView(Contract.View view) {
        this.view = view;
    }

    @Override
    public List<Appointment> loadListAppointment() {
        List<Appointment> list = model.getListAppointment();
        return  list;
    }

    @Override
    public void addAppointment(Appointment appointment) {
        model.addAppointmentModel(appointment);
    }

    @Override
    public List<Vaccine> loadListVaccine() {
        List<Vaccine> list = model.getListVaccine();
        return list;
    }

    @Override
    public void addVaccine(Vaccine vaccine) {
        model.addVaccineModel(vaccine);
    }
}
