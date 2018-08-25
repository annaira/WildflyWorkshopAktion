package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Aktion;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import de.dpunkt.myaktion.controller.AktionEditController.Mode;

@SessionScoped
@Named
public class AktionListController implements Serializable {

    @Inject
    private AktionEditController aktionEditController;

    @Inject
    private SpendeListController spendeListController;

    @Inject
    private SpendeFormEditController spendeFormEditController;

    public String doAddAktion(Aktion aktion) {
        aktionEditController.setAktionToEdit(Mode.ADD);
        return Pages.AKTION_EDIT;
    }

    public String doEditAktion() {
        aktionEditController.setAktionToEdit(Mode.EDIT);
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
        System.out.println("Aktion löschen noch nicht implementiert");
    }
}
