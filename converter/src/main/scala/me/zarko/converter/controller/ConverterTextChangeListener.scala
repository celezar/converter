package me.zarko.converter.controller

import me.zarko.converter.model.MeasurementModel
import com.vaadin.ui.AbstractTextField
import com.vaadin.event.FieldEvents.TextChangeListener
import com.vaadin.event.FieldEvents.TextChangeEvent
import me.zarko.converter.model.MeasurementUnitModel

class ConverterTextChangeListener(measurement: MeasurementModel) extends TextChangeListener {

  override def textChange(event: TextChangeEvent): Unit = {
    try {
      var atf = event.getSource.asInstanceOf[AbstractTextField]
      // checks if entered text can be interpreted as float
      atf.setValue(event.getText.toFloat.toString)
      measurement.updateByUnitModel(atf.getData.asInstanceOf[MeasurementUnitModel])
    } catch {
      case e: Exception =>
    }

  }

}