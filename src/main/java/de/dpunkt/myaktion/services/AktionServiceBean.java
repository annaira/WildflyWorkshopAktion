package de.dpunkt.myaktion.services;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import de.dpunkt.myaktion.model.Aktion;

@RequestScoped
public class AktionServiceBean implements AktionService {

	@Override
	public List<Aktion> getAllAktionen() {
		return new LinkedList<Aktion>();
	}

}
