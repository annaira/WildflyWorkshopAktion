package de.dpunkt.myaktion.services;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.util.TecLog;

@RequestScoped
public class AktionServiceBean implements AktionService {
	
	@Inject
	@TecLog
	private Logger logger;

	@Override
	public List<Aktion> getAllAktionen() {
		logger.info("Entering AktionServiceBean.getAllAktionen()");
		return new LinkedList<Aktion>();
	}

}
