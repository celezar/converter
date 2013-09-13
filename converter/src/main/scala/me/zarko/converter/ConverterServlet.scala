package me.zarko.converter

import javax.servlet.annotation.WebServlet
import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.server.VaadinServlet

@WebServlet(value = Array("/*"), asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = classOf[ConverterApp])
class ConverterServlet extends VaadinServlet {

}