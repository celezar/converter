package me.zarko.converter.logic

import scala.collection.mutable.ArrayBuffer
import me.zarko.converter.model.MeasurementModel
import me.zarko.converter.model.MeasurementUnitModel

object MeasurementFactory {

  def getAllMeasurements(): ArrayBuffer[Measurement] = {
    /* 
     * This is the place where project can be extended by adding other ways for getting measurement types like Spring DI,
     * XML, web service, reflection etc.
     */
    var allConversions: ArrayBuffer[Measurement] = new ArrayBuffer[Measurement]()
    allConversions += getTemperatureMeasurement
    // --- enable line below for length conversion ---
    //allConversions += getLengthConversion
  }

  private def getTemperatureMeasurement(): Measurement = {
    val temperatureMeasurement = new Measurement("Temperature");

    //Celsius - chosen to be reference unit for temperature conversion
    val celsius = new MeasurementUnit("Celsius")

    //Fahrenheit
    val fahrenheit = new MeasurementUnit("Fahrenheit")
    fahrenheit.toReferenceValue = (value: String) => {
      var floatValue: Float = value.toFloat;
      (floatValue - 32) * 5 / 9 toString
    }
    fahrenheit.fromReferenceValue = (refValue: String) => {
      var floatValue: Float = refValue.toFloat
      floatValue * 9 / 5 + 32 toString
    }
    
    // --- enable block below for converision to kelvin ---
    /*
    //Kelvin
    val kelvin = new ConversionUnit("Kelvin")
    kelvin.toReferenceValue = (value: String) => {
      var floatValue: Float = value.toFloat;
      floatValue - 273.15 toString
    }
    kelvin.fromReferenceValue = (refValue: String) => {
      var floatValue: Float = refValue.toFloat
      floatValue + 273.15 toString
    }
    temperatureConversion.unitCollection += kelvin
    */

    temperatureMeasurement.unitCollection += celsius
    temperatureMeasurement.unitCollection += fahrenheit
    temperatureMeasurement
  }
  
  private def getLengthMeasurement(): Measurement = {
    val lengthMeasurement = new Measurement("Length");

    //Meters - chosen to be reference unit for lengthconversion
    val meters = new MeasurementUnit("Meters")

    //Feets
    val feets = new MeasurementUnit("Feets")
    feets.toReferenceValue = (value: String) => {
      var floatValue: Float = value.toFloat;
      floatValue / 3.28 toString
    }
    feets.fromReferenceValue = (refValue: String) => {
      var floatValue: Float = refValue.toFloat
      floatValue * 3.28 toString
    }
    
    //Yards
    val yards = new MeasurementUnit("Yards")
    yards.toReferenceValue = (value: String) => {
      var floatValue: Float = value.toFloat;
      floatValue / 1.09 toString
    }
    yards.fromReferenceValue = (refValue: String) => {
      var floatValue: Float = refValue.toFloat
      floatValue * 1.09 toString
    }
    
    //Inches
    val inches = new MeasurementUnit("Inches")
    inches.toReferenceValue = (value: String) => {
      var floatValue: Float = value.toFloat;
      floatValue / 39.37 toString
    }
    inches.fromReferenceValue = (refValue: String) => {
      var floatValue: Float = refValue.toFloat
      floatValue * 39.37 toString
    }
  

    lengthMeasurement.unitCollection += meters
    lengthMeasurement.unitCollection += feets
    lengthMeasurement.unitCollection += yards
    lengthMeasurement.unitCollection += inches
    lengthMeasurement
  }

}