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
import propertiesConfig.ManagerProperties;
import pojos.Appointment;
import pojos.Vaccine;

public class ManagerModel implements Contract.Model {

    private List<Appointment> appointmentList;
    private List<Vaccine> vaccinesList;
    private File fileAppointment;
    private List<String> jsonArrayAppointment;
    private List<String> jsonArrayVaccine;
    private File fileVaccine;

    @SuppressWarnings("unused")
    private Contract.Presenter presenter;
    ManagerProperties managerProperties = new ManagerProperties();

    public ManagerModel() throws IOException, ParseException {
        this.appointmentList = new ArrayList<>();
        this.vaccinesList = new ArrayList<>();
        createFileAppointment(managerProperties.getProperty("fileNameAppointments"));
        createFileVaccine(managerProperties.getProperty("fileNameVaccines"));
        jsonToAppointmentList();
        jsonToVaccineList();
    }

    private JSONArray readFilejsonAppointment(String fileName)
            throws IOException, org.json.simple.parser.ParseException {
        if (fileAppointment.exists() && fileAppointment.length() != 0) {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            return (JSONArray) obj;
        }
        return null;
    }

    private JSONArray readFileVaccinejson(String fileName) throws IOException, org.json.simple.parser.ParseException {
        if (fileVaccine.exists() && fileVaccine.length() != 0) {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            return (JSONArray) obj;
        }
        return null;
    }

    private void createFileAppointment(String filename) {
        fileAppointment = new File(filename);
    }

    private void createFileVaccine(String filename) {
        fileVaccine = new File(filename);
    }

    private String removeSpaces(String string) {
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            String temp = string.substring(i, i + 1);
            if (!temp.equals(" ")) {
                newString += temp;
            }
        }
        return newString;
    }

    private List<String> appointmentListToJsonList() {
        jsonArrayAppointment = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            String jsonFormat = String.format(
                    "{\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":%s}",
                    managerProperties.getProperty("json.key.date"), appointment.getDate(),
                    managerProperties.getProperty("json.key.completename"), appointment.getCompletename(),
                    managerProperties.getProperty("json.key.typeDocument"), appointment.getTypeDocument(),
                    managerProperties.getProperty("json.key.documentNumber"), appointment.getDocumentNumber(),
                    managerProperties.getProperty("json.key.relationship"), appointment.getRelationship(),
                    managerProperties.getProperty("json.key.petName"), appointment.getPetName(),
                    managerProperties.getProperty("json.key.petType"), appointment.getPetType(),
                    managerProperties.getProperty("json.key.vaccinesApplied"),
                    new Gson().toJson(appointment.getVaccinesApplied()));

            if (appointmentList.indexOf(appointment) != appointmentList.size() - 1) {
                jsonArrayAppointment.add(jsonFormat + "," + "\n");
            } else {
                jsonArrayAppointment.add(jsonFormat + "\n");
            }
        }
        return jsonArrayAppointment;
    }

    private void jsonToAppointmentList() throws IOException, ParseException {
        if (fileAppointment.exists() && fileAppointment.length() != 0) {
            JSONArray jsonArrayAppointment = readFilejsonAppointment(managerProperties.getProperty("fileNameAppointments"));
            for (int i = 0; i < jsonArrayAppointment.size(); i++) {
                JSONObject appointmentJson = (JSONObject) jsonArrayAppointment.get(i);
                Appointment appointment = new Appointment();
                appointment.setDate((String) appointmentJson.get(managerProperties.getProperty("json.key.date")));
                appointment.setCompletename((String) appointmentJson.get(managerProperties.getProperty("json.key.completename")));
                appointment.setTypeDocument((String) appointmentJson.get(managerProperties.getProperty("json.key.typeDocument")));
                appointment.setDocumentNumber((String) appointmentJson.get(managerProperties.getProperty("json.key.documentNumber")));
                appointment.setRelationship((String) appointmentJson.get(managerProperties.getProperty("json.key.relationship")));
                appointment.setPetName((String) appointmentJson.get(managerProperties.getProperty("json.key.petName")));
                appointment.setPetType((String) appointmentJson.get(managerProperties.getProperty("json.key.petType")));
                JSONArray vaccinesJsonArray = (JSONArray) appointmentJson.get(managerProperties.getProperty("json.key.vaccinesApplied"));
                List<Vaccine> vaccinesList = new ArrayList<>();
    
                if (vaccinesJsonArray == null) {
                    vaccinesJsonArray = new JSONArray();
                }
                for (Object vaccineObject : vaccinesJsonArray) {
                    JSONObject vaccineJson = (JSONObject) vaccineObject;
                    Vaccine vaccine = new Vaccine();
                    vaccine.setName((String) vaccineJson.get(managerProperties.getProperty("json.key.vaccine.name")));
                    vaccine.setSpecies((String) vaccineJson.get(managerProperties.getProperty("json.key.vaccine.specie")));
                    vaccine.setDuration((String) vaccineJson.get(managerProperties.getProperty("json.key.vaccine.duration")));
                    vaccinesList.add(vaccine);
                }
    
                appointment.setVaccinesApplied(vaccinesList);
                appointmentList.add(appointment);
            }
        }
    }

    private void jsonToVaccineList() throws IOException, ParseException {
        if (fileVaccine.exists() && fileVaccine.length() != 0) {
            JSONArray jsonArrayVaccine = readFileVaccinejson(managerProperties.getProperty("fileNameVaccines"));
            for (int i = 0; i < jsonArrayVaccine.size(); i++) {
                JSONObject vaccineJson = (JSONObject) jsonArrayVaccine.get(i);
                Vaccine vaccine = new Vaccine();
                vaccine.setName((String) vaccineJson.get(managerProperties.getProperty("json.key.vaccine.name")));
                vaccine.setSpecies((String) vaccineJson.get(managerProperties.getProperty("json.key.vaccine.specie")));
                vaccine.setDuration((String) vaccineJson.get(managerProperties.getProperty("json.key.vaccine.duration")));
                vaccinesList.add(vaccine);
            }
        }
    }

    private List<String> vaccineToJsonList() {
        jsonArrayVaccine = new ArrayList<>();
        for (Vaccine vaccine : vaccinesList) {
            String jsonFormat = String.format("{\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\"}",
                    managerProperties.getProperty("json.key.vaccine.name"), vaccine.getName(),
                    managerProperties.getProperty("json.key.vaccine.specie"), vaccine.getSpecies(),
                    managerProperties.getProperty("json.key.vaccine.duration"), vaccine.getDuration());
    
            if (vaccinesList.indexOf(vaccine) != vaccinesList.size() - 1) {
                jsonArrayVaccine.add(jsonFormat + "," + "\n");
            } else {
                jsonArrayVaccine.add(jsonFormat + "\n");
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
    public void writeListVaccine() {
        vaccineToJsonList();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileVaccine))) {
            writer.write("[" + "\n");
            for (String vaccine : jsonArrayVaccine) {
                writer.write(vaccine);
            }
            writer.write("]");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    @Override
    public List<Appointment> filterByDate(String date) {
        List<Appointment> fList = new ArrayList<>();
        for (Appointment appointment : appointmentList) { 
            if (appointment.getDate().equals(date.toString())) {
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
        List<Appointment> fList = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            if (appointment.getVaccinesApplied() != null) {
                for (Vaccine vaccine : appointment.getVaccinesApplied()) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(managerProperties.getProperty("date.format"));
                    String dateString = appointment.getDate();
                    LocalDate vaccineDate = LocalDate.parse(dateString, formatter);
                    LocalDate newDate = vaccineDate.plusDays(Integer.parseInt(vaccine.getDuration()));
                    if (newDate.isBefore(LocalDate.now().plusDays(16))) {
                        fList.add(appointment);
                    }
                }
            }
        }
        return fList;
    }
}
