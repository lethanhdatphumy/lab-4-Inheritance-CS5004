import sensorcomp.IDiscreteSensor;
import sensorcomp.ISensor;
import sensorcomp.WaterSensor;

/**
 * Application entry point for running sensor demos.
 * Demonstrates water sensor behavior by taking multiple readings
 * and reporting both numeric values and flooding status.
 */
public class Main {

  /**
   * Run the application.
   * Creates a WaterSensor and performs 10 consecutive readings,
   * displaying water level and flooding status for each.
   *
   * @param args command-line arguments (unused)
   */
  public static void main(String[] args) {
    ISensor sensor = new WaterSensor();
    for (int i = 0; i < 10; i++) {
      System.out.println("Water reading = " + sensor.takeNewReading() + " inches");
      System.out.println(
          "Our basement is flooding (True/False): " + ((IDiscreteSensor) sensor).status());
    }
  }
}
