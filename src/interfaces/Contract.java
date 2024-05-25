package interfaces;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.json.simple.parser.ParseException;
import pojos.Appointment;
import pojos.Vaccine;

public interface Contract {
    public interface Model {
        public void setPresenter(Presenter presenter);
        public List<Appointment> getListAppointment();
        public void addAppointmentModel(Appointment appointment);
    }

    public interface Presenter {
        public void setView(View view);
        public void setModel(Model model);
        public List<Appointment> loadListAppointment();
        public void addAppointment(Appointment appointment);
    }

    public interface View {
        public void setPresenter(Presenter presenter);
        public List<Appointment> requestListAppointment();
        public void begin ();
    }
}
