package sensorcomp;

/**
 * Models a water-level sensor with a discrete flooding status. Status is true (flooding) when the
 * numeric reading exceeds 0.5; otherwise false.
 */
public class WaterSensor implements IDiscreteSensor {
  private final AtmosphericSensor delegate;
  private boolean currentStatus;

  /**
   * Constructs a WaterSensor with a specified initial water level reading.
   *
   * @param initialValue the initial water level in inches (must be non-negative)
   * @throws IllegalArgumentException if initialValue is negative
   */
  public WaterSensor(double initialValue) {
    if (initialValue < 0) {
      throw new IllegalArgumentException("The current value must be greater or equal to 0");
    }
    this.delegate = new AtmosphericSensor(initialValue);
    this.currentStatus = initialValue > 0.5;
  }

  /**
   * Constructs a WaterSensor with a default initial water level of 0.0 inches.
   */
  public WaterSensor() {
    this(0);
  }

  /**
   * Returns the current flooding status of the sensor.
   *
   * @return true if the location is flooding (reading &gt; 0.5 inches), false otherwise
   */
  @Override
  public boolean status() {
    return currentStatus;
  }

  /**
   * Toggles the flooding status to its opposite value.
   */
  @Override
  public void flipStatus() {
    currentStatus = !currentStatus;
  }

  /**
   * Explicitly sets the flooding status.
   *
   * @param value the desired flooding status (true for flooding, false for not flooding)
   */
  @Override
  public void setStatus(boolean value) {
    currentStatus = value;
  }

  /**
   * Returns the previous water level reading (prior to the most recent takeNewReading call).
   *
   * @return the last water level reading in inches
   */
  @Override
  public double lastReading() {
    return delegate.lastReading();
  }

  /**
   * Takes a new water level reading from the sensor and updates the flooding status.
   * The flooding status is set to true if the reading exceeds 0.5 inches, false otherwise.
   *
   * @return the new water level reading in inches
   */
  @Override
  public double takeNewReading() {
    double value = this.delegate.takeNewReading();
    this.currentStatus = value > 0.5;
    return value;
  }
}
