import co.edu.uptc.text.ManagerProperties;

public class GlobalProperties {
    ManagerProperties managerProperties = new ManagerProperties();
    public static String FILE_NAME_APPOINTMENTS = "appointments.json";

    public void setProperties() {
        managerProperties.setFileName("data.properties");
    }
}
