package me.zarko.converter.view

import me.zarko.converter.model.MeasurementModel
import me.zarko.converter.logic.MeasurementUnit
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.TextField
import com.vaadin.ui.Component
import me.zarko.converter.controller.ConverterTextChangeListener
import com.vaadin.ui.AbstractTextField
import com.vaadin.event.FieldEvents.TextChangeListener
import com.vaadin.event.FieldEvents.TextChangeEvent
import com.vaadin.data.util.ObjectProperty
import me.zarko.converter.model.MeasurementUnitModel
import com.vaadin.ui.Panel

// Factory for creating UI elements
object MeasurementUIFactory {

  def createMeasurementView(measurementModel: MeasurementModel): Component = {
    val mainConversionLayout: HorizontalLayout = new HorizontalLayout
    val controller = new ConverterTextChangeListener(measurementModel)
    measurementModel.unitModelCollection.foreach(unitModel => {
      var component = MeasurementUIFactory.this.createUnitView(unitModel)
      component.addListener(controller)
      mainConversionLayout addComponent(component)
    })
    val measurementView: Panel = new Panel(measurementModel.measurement.measurementName) 
    measurementView.setContent(mainConversionLayout)
    measurementView
  }

  def createUnitView(unitAdapter: MeasurementUnitModel): AbstractTextField = {
    var measurementUnitView: TextField = new TextField(unitAdapter.unit.unitName)
    measurementUnitView.setPropertyDataSource(unitAdapter.propertyAdapter)
    measurementUnitView.setData(unitAdapter)
    measurementUnitView.setImmediate(true)
    measurementUnitView
  }

}