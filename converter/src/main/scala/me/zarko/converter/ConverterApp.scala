package me.zarko.converter

import com.vaadin.annotations.Theme
import com.vaadin.ui.UI
import com.vaadin.server.VaadinServlet
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.VerticalLayout
import scala.collection.mutable.ArrayBuffer
import me.zarko.converter.view.MeasurementUIFactory
import me.zarko.converter.logic.MeasurementFactory
import me.zarko.converter.model.MeasurementModel
import me.zarko.converter.logic.Measurement

@Theme("converter")
class ConverterApp extends UI {

  override def init(request: VaadinRequest): Unit = {

    // root element for page
    var baseLayout: VerticalLayout = new VerticalLayout()
    this.setContent(baseLayout)

    // getting all conversions and setting conversion models
    val allConversionModels: ArrayBuffer[MeasurementModel] = new ArrayBuffer[MeasurementModel]()
    MeasurementFactory.getAllMeasurements.foreach(conversion => allConversionModels += new MeasurementModel(conversion))

    // creating views and adding them to the page
    allConversionModels.foreach(item => baseLayout.addComponent(MeasurementUIFactory.createMeasurementView(item)))

  }

}