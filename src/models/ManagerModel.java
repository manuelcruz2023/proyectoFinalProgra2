package models;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import interfaces.Contract;
import pojos.Appointment;
import pojos.Vaccine;

public class ManagerModel implements Contract.Model {

    private String path;
    private List<Appointment> appointmentList;
    private List<Vaccine> vaccinesList;
    @SuppressWarnings("unused")
    private Contract.Presenter presenter;

    public void setPath(String path) {
        this.path = path;
    }
    public ManagerModel() {
        this.appointmentList = new ArrayList<>();
        this.vaccinesList = new ArrayList<>();
    }

    public JSONArray readFilejson() throws IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(path));
        return (JSONArray) obj;
    }

    public Long vaccineDuration(LocalDate appointmentDate) {
        LocalDate expireDate = LocalDate.now();
        long days = ChronoUnit.DAYS.between(appointmentDate, expireDate);
        System.out.println(days);
        return days;
    }

    @Override
    public List<Appointment> getListAppointment() {
        return appointmentList;
    }
    
    @Override
    public void addAppointmentModel(Appointment appointment) {
        appointmentList.add(appointment);
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

}
