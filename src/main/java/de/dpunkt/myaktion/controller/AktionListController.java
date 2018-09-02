package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.dpunkt.myaktion.controller.AktionEditController.Mode;
import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.util.Events.Deleted;

@ViewScoped
@Named
public class AktionListController implements Serializable {

	private static final long serialVersionUID = 1163110341764473909L;

	@Inject
	private AktionEditController aktionEditController;

	@Inject
	private SpendeListController spendeListController;

	@Inject
	private SpendeFormEditController spendeFormEditController;

	@Inject
	@Deleted
	private Event<Aktion> aktionDeleteEventSrc;

	public String doAddAktion(Aktion aktion) {
		aktionEditController.setAktionToEdit(Mode.ADD);
		return Pages.AKTION_EDIT;
	}

	public String doEditAktion(Aktion aktion) {
		aktionEditController.setAktionToEdit(Mode.EDIT, aktion);
		return Pages.AKTION_EDIT;
	}

	public String doEditSpendeForm(Aktion aktion) {
		spendeFormEditController.setAktion(aktion);
		return Pages.SPENDE_FORM_EDIT;
	}

	public String doListSpende(Aktion aktion) {
		spendeListController.setAktion(aktion);
		return Pages.SPENDE_LIST;
	}

	public void doDeleteAktion(Aktion aktion) {
		aktionDeleteEventSrc.fire(aktion);
	}
}
