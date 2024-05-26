package models;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import interfaces.Contract;
import pojos.Appointment;
import pojos.Vaccine;

public class ManagerModel implements Contract.Model {

    private String path;
    private List<Appointment> appointmentList;
    private List<Vaccine> vaccinesList;
    private File fileAppointment;
    private List<String> jsonArrayAppointment;
    private List<String> jsonArrayVaccine;

    @SuppressWarnings("unused")
    private Contract.Presenter presenter;

    public void setPath(String path) {
        this.path = path;
    }

    public ManagerModel() throws IOException, ParseException {
        this.appointmentList = new ArrayList<>();
        this.vaccinesList = new ArrayList<>();
        createFile("appointments.json");
        jsonToAppointmentList();
    }

    public JSONArray readFilejson(String fileName) throws IOException, org.json.simple.parser.ParseException {
        if (fileAppointment.exists() && fileAppointment.length() != 0) {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            return (JSONArray) obj;
        }
        return null;
    }
    

    public void createFile(String filename) {
        fileAppointment = new File(filename);
    }

    public String removeSpaces(String string) {
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            String temp = string.substring(i, i + 1);
            if (!temp.equals(" ")) {
                newString += temp;
            }
        }
        return newString;
    }

    @SuppressWarnings("unchecked")
    private void jsonToAppointmentList() throws IOException, ParseException {
        if (fileAppointment.exists() && fileAppointment.length() != 0) {
            JSONArray jsonArrayAppointment = readFilejson("appointments.json");
            for (int i = 0; i < jsonArrayAppointment.size(); i++) {
                JSONObject appointmentJson = (JSONObject) jsonArrayAppointment.get(i);
                Appointment appointment = new Appointment();
                appointment.setDate((String) appointmentJson.get("date"));
                appointment.setCompletename((String) appointmentJson.get("completename"));
                appointment.setTypeDocument((String) appointmentJson.get("typeDocument"));
                appointment.setDocumentNumber((String) appointmentJson.get("documentNumber"));
                appointment.setRelationship((String) appointmentJson.get("relationship"));
                appointment.setPetName((String) appointmentJson.get("petName"));
                appointment.setPetTypeAndSex((String) appointmentJson.get("petTypeAndSex"));
                appointment.setVaccinesApplied((List<Vaccine>) appointmentJson.get("vaccinesApplied"));
                appointmentList.add(appointment);
            }

        }
    }

    private List<String> appointmentListToJsonList() {
        jsonArrayAppointment = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            if (appointmentList.indexOf(appointment) != appointmentList.size() - 1) {
                jsonArrayAppointment.add(
                        "{\"date\":\"" + appointment.getDate()
                                + "\",\"completename\":\"" + appointment.getCompletename()
                                + "\",\"typeDocument\":\"" + appointment.getTypeDocument()
                                + "\",\"documentNumber\":\"" + appointment.getDocumentNumber()
                                + "\",\"relationship\":\"" + appointment.getRelationship()
                                + "\",\"petName\":\"" + appointment.getPetName()
                                + "\",\"petTypeAndSex\":\"" + appointment.getPetTypeAndSex()
                                + "\",\"vaccinesApplied\":" + new Gson().toJson(appointment.getVaccinesApplied()) + "}"
                                + "," + "\n");
            } else {
                jsonArrayAppointment.add(
                        "{\"date\":\"" + appointment.getDate()
                                + "\",\"completename\":\"" + appointment.getCompletename()
                                + "\",\"typeDocument\":\"" + appointment.getTypeDocument()
                                + "\",\"documentNumber\":\"" + appointment.getDocumentNumber()
                                + "\",\"relationship\":\"" + appointment.getRelationship()
                                + "\",\"petName\":\"" + appointment.getPetName()
                                + "\",\"petTypeAndSex\":\"" + appointment.getPetTypeAndSex()
                                + "\",\"vaccinesApplied\":" + new Gson().toJson(appointment.getVaccinesApplied()) + "}"
                                + "\n");
            }
        }
        return jsonArrayAppointment;
    }

    private void jsonToVaccineList() throws IOException, ParseException {
        if (fileAppointment.exists() && fileAppointment.length() != 0) {
            JSONArray jsonArrayVaccine = readFilejson("vaccines.json");
            for (int i = 0; i < jsonArrayAppointment.size(); i++) {
                JSONObject vaccineJson = (JSONObject) jsonArrayVaccine.get(i);
                Vaccine vaccine = new Vaccine();
                vaccine.setName((String) vaccineJson.get("name"));
                vaccine.setSpecies((String) vaccineJson.get("species"));
                vaccine.setExpiryDate((String) vaccineJson.get("expiryDate"));
                vaccinesList.add(vaccine);
            }

        }
    }

    private List<String> vaccineToJsonList() {
        jsonArrayVaccine = new ArrayList<>();
        for (Vaccine vaccine : vaccinesList) {
            if (vaccinesList.indexOf(vaccine) != vaccinesList.size() - 1) {
                jsonArrayVaccine.add(
                    "{\"name\":\"" + vaccine.getName()
                    + "\",\"specie\":\"" + vaccine.getSpecies()
                    + "\",\"expityDate\":\"" + vaccine.getExpiryDate() + "}" + "," + "\n");
            } else {
                jsonArrayVaccine.add(
                    "{\"name\":\"" + vaccine.getName()
                    + "\",\"specie\":\"" + vaccine.getSpecies()
                    + "\",\"expityDate\":\"" + vaccine.getExpiryDate() + "}" + "\n");
            }
        }
        return jsonArrayVaccine;
    }

    @Override
    public List<Appointment> getListAppointment() {
        return appointmentList;
    }

    @Override
    public void addAppointmentModel(Appointment appointment) {
        appointmentList.add(appointment);
        writeListAppointment();
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public List<Vaccine> getListVaccine() {
        return vaccinesList;
    }

    @Override
    public void addVaccineModel(Vaccine vaccine) {
        vaccinesList.add(vaccine);
    }

    @Override
    public void writeListAppointment() {
        appointmentListToJsonList();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileAppointment))) {
            writer.write("[" + "\n");
            for (String appointment : jsonArrayAppointment) {
                writer.write(appointment);
            }
            writer.write("]");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    @Override
    public void writeListVaccine(String fileName) {
        throw new UnsupportedOperationException("Unimplemented method 'writeListVaccine'");
    }

    @Override
    public List<Appointment> filterByDate() {
        LocalDate date = LocalDate.now();
        List<Appointment> fList = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            String dateStr = appointment.getDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dateStr, formatter);
            if (localDate.isEqual(date)) {
                fList.add(appointment);
            }
        }
        return fList;
    }

    @Override
    public List<Appointment> filterByResponsible(String documentNumber) {
        List<Appointment> fList = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            if (appointment.getDocumentNumber().equals(removeSpaces(documentNumber))) {
                fList.add(appointment);
            }
        }
        return fList;
    }

    @Override
    public List<Appointment> filterByVaccineSoonToExpire() {
        LocalDate today = LocalDate.now();
        LocalDate soon = today.plusDays(30); // Ajusta este valor según lo que consideres "próximo a expirar"
        List<Appointment> fList = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            for (Vaccine vaccine : appointment.getVaccinesApplied()) {
                // if (vaccine.getExpiryDate().isBefore(soon)) {
                //     fList.add(appointment);
                //     break;
                // }
            }
        }
        return fList;
    }

}
