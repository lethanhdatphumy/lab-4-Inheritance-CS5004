package sensorcomp;

/**
 * Models a water-level sensor with a discrete flooding status.
 * Status is true (flooding) when the numeric reading exceeds 0.5; otherwise false.
 */
public class WaterSensor implements IDiscreteSensor {
  private double currentValue;
  private double lastValue;
  private boolean currentStatus;

  /**
   * Create a WaterSensor with an initial reading.
   * Both current and last readings are set to the provided value.
   * @param currentValue initial numeric reading (must be >= 0)
   * @throws IllegalArgumentException if currentValue is negative
   */
  public WaterSensor(double currentValue) {
    if (currentValue < 0) {
      throw new IllegalArgumentException("the current value must be equal or greater tha 0");
    }
    this.currentValue = this.lastValue = currentValue;
  }

  /**
   * Create a WaterSensor initialized to 0.
   */
  public WaterSensor() {
    this(0);
  }

  /**
   * The current flooding status derived from the latest reading.
   * @return true if flooding detected; false otherwise
   */
  @Override
  public boolean status() {
    return this.currentStatus;
  }

  /**
   * Toggle the discrete flooding status.
   */
  @Override
  public void flipStatus() {
    this.currentStatus = !this.currentStatus;
  }

  /**
   * Set the discrete flooding status explicitly.
   * @param value desired status
   */
  @Override
  public void setStatus(boolean value) {
    this.currentStatus = value;
  }

  /**
   * Return the previous numeric reading.
   * @return last reading value
   */
  @Override
  public double lastReading() {
    return this.lastValue;
  }

  /**
   * Obtain the next numeric reading from SensorData, update last/current,
   * and recompute flooding status based on a 0.5 threshold.
   * @return the new current reading
   */
  @Override
  public double takeNewReading() {

    // Simulate a sensor reading
    this.lastValue = this.currentValue; // save previous
    this.currentValue = SensorData.currentSensorReading();

    if (this.currentValue > 0.5) {
      this.currentStatus = true; // flooding
    } else {
      this.currentStatus = false; // not flooding
    }
    return this.currentValue;
  }
}
