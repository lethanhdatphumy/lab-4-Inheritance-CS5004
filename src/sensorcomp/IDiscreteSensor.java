package sensorcomp;

/**
 * A sensor with a discrete on/off status in addition to numeric readings.
 * Implementations should override the default numeric methods with real behavior.
 */
public interface IDiscreteSensor extends ISensor {
  /**
   * The current discrete status (e.g., on/off, flooding/not flooding).
   * @return true when active/on; false otherwise
   */
  boolean status(); // discrete values like "on"/ off modeled here

  /**
   * Toggle the current discrete status.
   */
  void flipStatus();

  /**
   * Explicitly set the discrete status.
   * @param value desired status
   */
  void setStatus(boolean value);

  /**
   * Default numeric last reading for discrete sensors.
   * Implementations should override to provide meaningful values.
   * @return 0 by default
   */
  default double lastReading() {
    return 0;
  }

  /**
   * Default implementation that does not perform a real reading.
   * Implementations should override to return an actual reading.
   * @return 0 by default
   */
  @Override
  default double takeNewReading() {
    return 0;
  }
}
