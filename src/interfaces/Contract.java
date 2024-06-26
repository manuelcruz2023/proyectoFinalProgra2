package interfaces;

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

        public void writeListAppointment();
        public void writeListVaccine();

        public List<Appointment> filterByDate(String date);
        public List<Appointment> filterByResponsible(String documentNumber);
        public List<Appointment> filterByVaccineSoonToExpire();
        public List<Appointment> filterByWeight(String weight, String filter);
    }

    public interface Presenter {
        public void setView(View view);
        public void setModel(Model model);

        public List<Appointment> loadListAppointment();
        public void addAppointment(Appointment appointment);

        public List<Vaccine> loadListVaccine();
        public void addVaccine(Vaccine vaccine);    
        
        public List<Appointment> loadFilterByDate(String date);
        public List<Appointment> loadFilterByResponsible(String documentNumber);
        public List<Appointment> loadFilterByVaccineSoonToExpire();
        public List<Appointment> loadFilterByWeight(String weight, String filter);

        public void updateJsonAppointments();
        public void updateJsonVaccines();
    }

    public interface View {
        public void setPresenter(Presenter presenter);
        public void begin ();
    }
}
