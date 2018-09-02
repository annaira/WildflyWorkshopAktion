package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.util.Events.Added;

@SessionScoped
@Named
public class AktionEditController implements Serializable {

	private static final long serialVersionUID = -99279115241068449L;

	@Inject
	@Added
	private Event<Aktion> aktionAddEventSrc;

	public enum Mode {
		EDIT, ADD
	}

	private Aktion aktion;
	private Mode mode;

	public Mode getMode() {
		return mode;
	}

	public Aktion getAktion() {
		return aktion;
	}

	public void setAktionToEdit(Mode mode) {
		setAktionToEdit(mode, new Aktion());
	}

	void setAktionToEdit(Mode mode, Aktion aktion) {
		this.aktion = aktion;
		this.mode = mode;
	}

	public String doSave() {
		if (getMode() == Mode.ADD) {
			aktionAddEventSrc.fire(aktion);
		}
		return Pages.AKTION_LIST;
	}

	public String doCancel() {
		return Pages.AKTION_LIST;
	}

	public String getTitle() {
		return getMode() == Mode.EDIT ? "Aktion editieren" : "Neue Aktion anlegen";
	}
}
