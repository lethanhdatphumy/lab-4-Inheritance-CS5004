package sensorcomp;

/**
 * A concrete sensor implementation that simulates atmospheric readings.
 * This sensor maintains both current and previous reading values and
 * retrieves new data from the SensorData stream.
 */
public class AtmosphericSensor implements ISensor {

  private double currentValue;
  private double lastValue;

  /**
   * Constructs an AtmosphericSensor with a specified initial reading value.
   *
   * @param value the initial sensor reading
   */
  public AtmosphericSensor(double value) {

    this.currentValue = this.lastValue = value;
  }

  /**
   * Constructs an AtmosphericSensor with a default initial reading of 0.0.
   */
  public AtmosphericSensor() {

    this(0);
  }

  /**
   * Captures a new reading from the sensor data stream, saving the previous reading.
   *
   * @return the new current sensor reading
   */
  @Override
  public double takeNewReading() {

    // Simulate a sensor reading
    this.lastValue = this.currentValue; // save previous
    this.currentValue = SensorData.currentSensorReading();

    return this.currentValue;
  }

  /**
   * Returns the previous sensor reading (prior to the most recent takeNewReading call).
   *
   * @return the last sensor reading
   */
  @Override
  public double lastReading() {

    return this.lastValue;
  }
}
