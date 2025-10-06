import sensorcomp.ISensor;
import sensorcomp.SensorData;
import sensorcomp.WaterSensor;
import sensorcomp.IDiscreteSensor;

/**
 * Application entry point for running sensor demos.
 */
public class Main {

  /**
   * Run the application.
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
