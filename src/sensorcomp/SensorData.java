package sensorcomp;

/**
 * Deterministic data source used to simulate hardware sensor readings.
 * Cycles through a fixed sequence of values for predictable testing.
 */
public class SensorData {
  private static double[] readings = {0.1, 0.4, 0.0, 0.51, 0.5, 0.7, 0.0, 2.2, 1.0};
  private static int counter = 0;

  /**
   * Get the next value in the sequence and advance the index, wrapping at the end.
   * @return next reading value
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
   * Reset the internal index so the next call returns the first reading.
   */
  public static void reset() {
    counter = 0;
  }
}
