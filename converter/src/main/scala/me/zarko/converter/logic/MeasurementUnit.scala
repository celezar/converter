package me.zarko.converter.logic

class MeasurementUnit (val unitName: String) {

  // if ConversionUnit represents reference unit these values should not be changed 
  var fromReferenceValue: (String) => String = (refValue: String) => refValue
  
  var toReferenceValue: (String) => String = (value: String) => value

}