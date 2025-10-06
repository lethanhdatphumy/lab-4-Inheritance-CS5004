package sensorcomp;

/**
 * Simulates an analog atmospheric sensor that provides continuous readings.
 * Maintains the current and last reading and pulls new values from SensorData.
 */
public class AtmosphericSensor implements ISensor {

  private double currentValue;
  private double lastValue;

  /**
   * Create a sensor initialized with an initial reading.
   * Both current and last readings are set to the provided value.
   * @param value initial reading
   */
  public AtmosphericSensor(double value) {

    this.currentValue = this.lastValue = value;
  }

  /**
   * Create a sensor initialized with a reading of 0.
   */
  public AtmosphericSensor() {

    this(0);
  }

  /**
   * Obtain the next reading from SensorData, shifting current to last.
   * @return the new current reading
   */
  @Override
  public double takeNewReading() {

    // Simulate a sensor reading
    this.lastValue = this.currentValue; // save previous
    this.currentValue = SensorData.currentSensorReading();

    return this.currentValue;
  }

  /**
   * Get the previous reading recorded before the most recent takeNewReading call.
   * @return the last reading value
   */
  @Override
  public double lastReading() {

    return this.lastValue;
  }
}
