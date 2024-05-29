package pojos;

import java.util.List;
public class Appointment {

    private String appointmentDate;
    private String completename;
    private String typeDocument;
    private String documentNumber;
    private String relationship;
    private String petName;
    private String petType;
    private List<Vaccine> vaccinesApplied;
    private String weight;

    public String getDate() {
        return appointmentDate;
    }
    public void setDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public String getCompletename() {
        return completename;
    }
    public void setCompletename(String completename) {
        this.completename = completename;
    }
    public String getTypeDocument() {
        return typeDocument;
    }
    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }
    public String getDocumentNumber() {
        return documentNumber;
    }
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
    public String getRelationship() {
        return relationship;
    }
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public String getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public String getPetType() {
        return petType;
    }
    public void setPetType(String petType) {
        this.petType = petType;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public List<Vaccine> getVaccinesApplied() {
        return vaccinesApplied;
    }
    public void setVaccinesApplied(List<Vaccine> vaccinesApplied) {
        this.vaccinesApplied = vaccinesApplied;
    }
}
