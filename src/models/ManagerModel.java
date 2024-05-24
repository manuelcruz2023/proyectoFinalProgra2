package models;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import pojos.Appointment;
import pojos.Vaccine;

public class ManagerModel {

    private Calendar appointmentDate;
    private Calendar expireDate;
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    private Appointment filterByDate(Date date) {
        Appointment personFilter = new Appointment();
        List<Appointment> appointments = new ArrayList<>();
        for (Appointment person : appointments) {
            if (person.getDate().equals(date)) {
                personFilter = person;
            }
        }
        return personFilter;
    }

    private List<Appointment> filterByResponsible(String relationship) {
        List<Appointment> appointment = new ArrayList<>();
        List<Appointment> appointmentsFilter = new ArrayList<>();
        for (Appointment appointment2 : appointment) {
            if (appointment2.getRelationship().equals(relationship)) {
                appointmentsFilter.add(appointment2);
            }
        }
        return appointmentsFilter;
    }

    public Long vaccineDuration() {
        appointmentDate = Calendar.getInstance();
        appointmentDate.set(2024, 4, 22);// TODO fecha quemada
        long millisAppointmentDate = appointmentDate.getTimeInMillis();
        expireDate = Calendar.getInstance();
        expireDate.set(2024, 4, 30);// TODO fecha quemada
        long millisExpireDate = expireDate.getTimeInMillis();
        long diff = millisExpireDate - millisAppointmentDate;
        long days = TimeUnit.MILLISECONDS.toDays(diff);
        System.out.println(days);
        return days;
    }

    private List<Appointment> filterBySoonToExpire() {
        List<Appointment> appointments = new ArrayList<>();
        List<Appointment> filterAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (vaccineDuration() <= 30) {
                filterAppointments.add(appointment);
            }
        }
        return filterAppointments;
    }

    public JSONArray readFilejson() throws IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(path));
        return (JSONArray) obj;
    }


    private List<Appointment> completeListAppointment() throws IOException, org.json.simple.parser.ParseException {
        List<Appointment> appointmentList = new ArrayList<>();
        JSONArray jsonArray = readFilejson();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject appointment = (JSONObject) jsonArray.get(i);
            Appointment appointment1 = new Appointment();
            appointment1.setCompletename((String) appointment.get("completename"));
            appointment1.setTypeDocument((String) appointment.get("typeDocument"));
            appointment1.setDocumentNumber((String) appointment.get("document"));
            appointment1.setPetName((String) appointment.get("petName"));
            appointment1.setRelationship((String) appointment.get("relationship"));
            appointment1.setPetTypeAndSex((String) appointment.get("petTypeAndSex"));
            appointment1.setDate((Calendar) appointment.get("date"));
            appointment1.setVaccinesApplied((Vaccine) appointment.get("vaccinesApplied"));
            appointmentList.add(appointment1);
        }
        return appointmentList;
    }
}
