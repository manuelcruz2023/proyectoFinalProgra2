package pojos;

import java.util.Calendar;
public class Appointment {

    private Calendar date;
    private String completename;
    private String typeDocument;
    private String documentNumber;
    private String relationship;
    private String petName;
    private String petTypeAndSex;
    private Vaccine vaccinesApplied;

    public Calendar getDate() {
        return date;
    }
    public void setDate(Calendar date) {
        this.date = date;
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
    public String getPetTypeAndSex() {
        return petTypeAndSex;
    }
    public void setPetTypeAndSex(String petTypeAndSex) {
        this.petTypeAndSex = petTypeAndSex;
    }
    public Vaccine getVaccinesApplied() {
        return vaccinesApplied;
    }
    public void setVaccinesApplied(Vaccine vaccinesApplied) {
        this.vaccinesApplied = vaccinesApplied;
    }
}
