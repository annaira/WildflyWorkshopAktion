package de.dpunkt.myaktion.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;

import java.util.logging.Logger;

public class Resources {

	@Produces
	@TecLog
	public Logger produceTechLog(InjectionPoint injectionPoint) {
		return Logger.getLogger("TecLog: " + injectionPoint.getMember().getDeclaringClass().getName());
	}

	@Produces
	@FachLog
	public Logger produceLog(InjectionPoint injectionPoint) {
		return Logger.getLogger("FachLog: " +injectionPoint.getMember().getDeclaringClass().getName());
	}

	@Produces
	@RequestScoped
	public FacesContext producesFacesContext() {
		return FacesContext.getCurrentInstance();
	}
}
