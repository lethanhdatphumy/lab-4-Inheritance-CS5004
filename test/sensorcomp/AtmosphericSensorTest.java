package sensorcomp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtmosphericSensorTest {
  @Test
  void testUserDefinedAtmosphericSensor() {
    assertEquals(1, new AtmosphericSensor(1).lastReading());
  }

  @Test
  void testTheDefaultConstructor() {
    assertEquals(0, new AtmosphericSensor().lastReading());
  }

  @Test
  void testTakeNewReading() {
    AtmosphericSensor test = new AtmosphericSensor(2);
    // private static double[] readings = {0.1, 0.4, 0.0, 0.51, 0.5, 0.7, 0.0, 2.2, 1.0};
    assertNotEquals(2, test.takeNewReading()); // they are not equal.
    assertNotEquals(0.4, test.takeNewReading()); // they are not equal.
  }

  @Test
  void testReset() {
    AtmosphericSensor test = new AtmosphericSensor();
    assertNotEquals(0.2, test.takeNewReading());
    assertEquals(0.4, test.takeNewReading()); // they are not equal.

    SensorData.reset();
    assertEquals(0.1, test.takeNewReading());
  }

}

