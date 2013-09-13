package me.zarko.converter.model

import scala.collection.mutable.ArrayBuffer
import me.zarko.converter.logic.Measurement

class MeasurementModel (val measurement: Measurement) {
  
  var unitModelCollection: ArrayBuffer[MeasurementUnitModel] = new ArrayBuffer[MeasurementUnitModel]();
  
  measurement.unitCollection.foreach(measurementUnit => unitModelCollection += new MeasurementUnitModel(measurementUnit))

  def updateByUnitModel(unitModel: MeasurementUnitModel): Unit = {
    var refValue = unitModel.referenceValue
    // changing values of all units except the one that caused change
    unitModelCollection foreach (unitAdapter =>
      if (unitAdapter ne unitModel)
        unitAdapter.updateValue(refValue))
  }

}