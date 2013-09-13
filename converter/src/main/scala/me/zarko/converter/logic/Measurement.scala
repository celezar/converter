package me.zarko.converter.logic

import scala.collection.mutable.ArrayBuffer

class Measurement (val measurementName : String) {
  
  var unitCollection: ArrayBuffer[MeasurementUnit] = new ArrayBuffer[MeasurementUnit]();

}