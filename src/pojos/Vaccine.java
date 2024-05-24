package pojos;

public class Vaccine {
    private String name;
    private String species;
    private String duration;
    private String ExpiryDate;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getExpiryDate() {
        return ExpiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }
}
