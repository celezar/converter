package me.zarko.converter.logic

import org.junit.Assert._
import org.junit.Before
import org.junit.Test
import me.zarko.converter.model.MeasurementModel


class MeasurementFactoryTest {

  val measurement = new Measurement("Temperature")

  val celsius = new MeasurementUnit("Celsius")

  val fahrenheit = new MeasurementUnit("Fahrenheit")
  
  measurement.unitCollection += celsius
  
  measurement.unitCollection += fahrenheit
  
  val measurementModel = new MeasurementModel(measurement);
  
  @Before
  @throws[Exception]
  def setUp(): Unit = {
    fahrenheit.fromReferenceValue = (refValue: String) => {
      var floatValue: Float = refValue.toFloat
      floatValue * 9 / 5 + 32 toString
    }

    fahrenheit.toReferenceValue = (refValue: String) => {
      var floatValue: Float = refValue.toFloat;
      (floatValue - 32) * 5 / 9 toString
    }
  }

  @Test
  def updateByCelsius(): Unit = {
    try {
      measurementModel.unitModelCollection(0).propertyAdapter.setValue("24")
      measurementModel.updateByUnitModel(measurementModel.unitModelCollection(0))
      assertEquals("Value not calculated correctly.", measurementModel.unitModelCollection(1).propertyAdapter.getValue.toFloat, 75.2, 0.0001)
    }
    catch {
      case e: Exception => fail("Exception thrown while updating by celsius.")
    }
  }

  @Test
  def updateByFahrenheit(): Unit = {
    try {
      measurementModel.unitModelCollection(1).propertyAdapter.setValue("75.2")
      measurementModel.updateByUnitModel(measurementModel.unitModelCollection(1))
      assertEquals("Value not calculated correctly.", measurementModel.unitModelCollection(0).propertyAdapter.getValue.toFloat, 24, 0.0001)
    }
    catch {
      case e: Exception => fail("Exception thrown while updating by fahrenheit.")
    }
  }

}