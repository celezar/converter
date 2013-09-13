package me.zarko.converter.model

import com.vaadin.data.util.ObjectProperty
import me.zarko.converter.logic.MeasurementUnit

class MeasurementUnitModel(val unit: MeasurementUnit) {

  val propertyAdapter: ObjectProperty[String] = new ObjectProperty[String]("")

  def updateValue(refValue: String): Unit = {
    var newValue = unit.fromReferenceValue(refValue)
    propertyAdapter.setValue(newValue)
  }

  def referenceValue(): String = {
    unit.toReferenceValue(propertyAdapter.getValue())
  }

}