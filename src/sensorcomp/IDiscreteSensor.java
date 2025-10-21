package sensorcomp;

/**
 * Represents a sensor that provides both numeric readings and discrete boolean status.
 * Extends ISensor to add status query and manipulation capabilities.
 * Typical use case: sensors that detect binary conditions (e.g., flooding/not flooding).
 */
public interface IDiscreteSensor extends ISensor {
  /**
   * Returns the current discrete status of the sensor.
   *
   * @return true if the monitored condition is active, false otherwise
   */
  boolean status();

  /**
   * Toggles the current status to its opposite value.
   */
  void flipStatus();

  /**
   * Explicitly sets the discrete status.
   *
   * @param value the desired status value
   */
  void setStatus(boolean value);

  /**
   * Default implementation returns 0. Concrete classes should override to provide actual behavior.
   *
   * @return 0 by default
   */
  default double lastReading() {
    return 0;
  }

  /**
   * Default implementation returns 0. Concrete classes should override to provide actual behavior.
   *
   * @return 0 by default
   */
  @Override
  default double takeNewReading() {
    return 0;
  }
}