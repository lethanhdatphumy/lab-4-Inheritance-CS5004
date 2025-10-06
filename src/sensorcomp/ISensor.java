package sensorcomp;

/**
 * Common contract for sensors that produce numeric readings over time.
 */
public interface ISensor {
    /**
     * Capture and return a new reading from the underlying source.
     * @return the new reading value
     */
    double takeNewReading();

    /**
     * Return the previous reading (prior to the most recent takeNewReading call).
     * @return the last reading value
     */
    double lastReading();
}