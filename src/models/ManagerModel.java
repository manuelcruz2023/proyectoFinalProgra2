package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
    List<JSONObject> jsonArrayAppointment;
    private File fileAppointment;
    @SuppressWarnings("unused")
    private Contract.Presenter presenter;

    public void setPath(String path) {
        this.path = path;
    }

    public ManagerModel() {
        this.appointmentList = new ArrayList<>();
        this.vaccinesList = new ArrayList<>();
        createFile("filename.json");
    }

    public JSONArray readFilejson() throws IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(path));
        return (JSONArray) obj;
    }

    @SuppressWarnings("unchecked")
    private List<JSONObject> appointmentListToJsonList() {
        jsonArrayAppointment = new ArrayList<>();

        for (Appointment appointment : appointmentList) {
            JSONObject obj = new JSONObject();
            obj.put("completename", appointment.getCompletename());
            obj.put("documentNumber", appointment.getDocumentNumber());
            obj.put("relationship", appointment.getRelationship());
            obj.put("petName", appointment.getPetName());
            obj.put("petTypeAndSex", appointment.getPetTypeAndSex());
            obj.put("date", appointment.getDate());
            obj.put("vaccinesApplied", appointment.getVaccinesApplied());
            jsonArrayAppointment.add(obj);
        }

        return jsonArrayAppointment;
    }

    public void createFile(String filename) {
        fileAppointment = new File(filename);
        if (!fileAppointment.exists()) {
            try {
                if (fileAppointment.createNewFile()) {
                    System.out.println("File created: " + fileAppointment.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.err.format("An IOException was thrown: %s%n", e);
            }
        }
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
            writer.write(jsonArrayAppointment.toString());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    @Override
    public void writeListVaccine(String fileName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeListVaccine'");
    }
}
