package sensorcomp;

/**
 * Provides a simulated stream of sensor readings for testing purposes.
 * The class cycles through a predefined array of water level readings.
 */
public class SensorData {
  private static double[] readings = {0.1, 0.4, 0.0, 0.51, 0.5, 0.7, 0.0, 2.2, 1.0};
  private static int counter = 0;

  /**
   * Returns the next reading from the simulated data stream.
   * The stream cycles back to the beginning after all readings have been returned.
   *
   * @return the current sensor reading value
   */
  public static double currentSensorReading() {
    int value = counter;
    counter++;
    if (counter >= readings.length) {
      counter = 0;
    }
    return readings[value];
  }

  /**
   * Resets the reading stream back to the first value.
   * Useful for ensuring consistent test results.
   */
  public static void reset() {
    counter = 0;
  }
}
