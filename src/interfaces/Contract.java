package interfaces;

import java.io.IOException;
import java.util.List;
import pojos.Appointment;
import pojos.Vaccine;

public interface Contract {
    public interface Model {
        public void setPresenter(Presenter presenter);
        public List<Appointment> getListAppointment();
        public void addAppointmentModel(Appointment appointment);
        public List<Vaccine> getListVaccine();
        public void addVaccineModel(Vaccine vaccine);
        public void writeListAppointment() throws IOException;
        public void writeListVaccine(String fileName);
    }

    public interface Presenter {
        public void setView(View view);
        public void setModel(Model model);
        public List<Appointment> loadListAppointment();
        public void addAppointment(Appointment appointment);
        public List<Vaccine> loadListVaccine();
        public void addVaccine(Vaccine vaccine);    
    }

    public interface View {
        public void setPresenter(Presenter presenter);
        public List<Appointment> requestListAppointment();
        public void begin ();
    }
}
