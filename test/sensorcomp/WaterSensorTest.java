package sensorcomp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterSensorTest {
  @Test
  void testInvalidConstructor() {
    assertThrows(IllegalArgumentException.class, () -> new WaterSensor(-1));
  }

  @Test
  void testValidConstructor() {
    WaterSensor testWaterSensor = new WaterSensor(2.0);
    assertEquals(2.0, testWaterSensor.lastReading());
  }

  @Test
  void testDefaultConstructor() {
    WaterSensor testWaterSensor = new WaterSensor();
    assertEquals(0, testWaterSensor.lastReading());
  }

  @Test
  public void testFloodingWhenAboveThreshold() {
    // Test reading > 0.5 detects flooding
    // readings = {0.1, 0.4, 0.0, 0.51, 0.5, 0.7, 0.0, 2.2, 1.0};
    WaterSensor testWaterSensor = new WaterSensor();
    for (int i = 0; i < 4; i++) {
      testWaterSensor.takeNewReading();
    }
    assertTrue(testWaterSensor.status());
  }

  @Test
  public void testNotFloodingWhenBelowThreshold() {
    // Test reading <= 0.5 does NOT detect flooding
    // readings = {0.1, 0.4, 0.0, 0.51, 0.5, 0.7, 0.0, 2.2, 1.0};
    WaterSensor testWaterSensor = new WaterSensor();
    for (int i = 0; i < 3; i++) {
      testWaterSensor.takeNewReading();
      assertFalse(testWaterSensor.status());
    }
  }

  @Test
  public void testBoundaryAtHalfInch() {
    // Test exactly 0.5
    WaterSensor sensor = new WaterSensor(0.5);
    boolean isFlooding = sensor.status();
    assertFalse(isFlooding);
  }

  @Test
  public void testDiscreteStatusMappingNotFlooding() {
    // Arrange: Reading <= 0.5 (NOT flooding)
    WaterSensor sensor = new WaterSensor(0.3);
    boolean status = sensor.status();
    assertFalse(status);
  }
}
