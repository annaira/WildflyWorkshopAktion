package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.AktionListProducer;
import de.dpunkt.myaktion.model.Aktion;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class AktionEditController implements Serializable {

    @Inject
    private AktionListProducer aktionListProducer;


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

    private void setAktionToEdit(Mode mode, Aktion aktion) {
        this.aktion = aktion;
        this.mode = mode;
    }

    public String doSave() {
        if (getMode() == Mode.ADD) {
            aktionListProducer.getAktionen().add(aktion);
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
