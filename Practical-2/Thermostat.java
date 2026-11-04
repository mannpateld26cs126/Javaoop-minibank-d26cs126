
public class Thermostat {

    private String location;
    private int temperature;

    private static final int MIN = 16;
    private static final int MAX = 30;

    private static int activeCount = 0;

    // Constructor with location and starting temperature
    public Thermostat(String location, int startTemp) {

        this.location = location;

        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            this.temperature = 22;
        }

        activeCount++;
    }

    // Constructor chaining using this()
    public Thermostat(String location) {
        this(location, 22);
    }

    // Increase temperature
    public void raise() {

        if (temperature < MAX) {
            temperature++;
        } else {
            System.out.println("Already at maximum (" + MAX + ").");
        }
    }

    // Decrease temperature
    public void lower() {

        if (temperature > MIN) {
            temperature--;
        } else {
            System.out.println("Already at minimum (" + MIN + ").");
        }
    }

    // Return current temperature
    public int getTemperature() {
        return temperature;
    }

    // Return total number of thermostats
    public static int getActiveCount() {
        return activeCount;
    }

    // Main method
    public static void main(String[] args) {

        Thermostat t1 = new Thermostat("Bedroom", 25);
        Thermostat t2 = new Thermostat("Living Room");

        System.out.println("Initial temperature: " + t1.getTemperature());

        // Raise temperature 10 times
        for (int i = 0; i < 10; i++) {
            t1.raise();
            System.out.println("Temperature: " + t1.getTemperature());
        }

        // Lower temperature 20 times
        for (int i = 0; i < 20; i++) {
            t1.lower();
            System.out.println("Temperature: " + t1.getTemperature());
        }

        System.out.println("Active thermostats: " + Thermostat.getActiveCount());
    }
}
