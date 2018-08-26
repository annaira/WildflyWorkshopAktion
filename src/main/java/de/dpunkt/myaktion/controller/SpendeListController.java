package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.model.Spende.Status;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class SpendeListController implements Serializable {
	
	private static final long serialVersionUID = 1885753183520722288L;

    private Aktion aktion;

    public Aktion getAktion() {
        return aktion;
    }

    public void setAktion(Aktion aktion) {
        this.aktion = aktion;
    }

    public String doOk() {
        return Pages.AKTION_LIST;
    }

    public String convertStatus(Status status) {
        switch (status) {
            case UEBERWIESEN:
                return "überwiesen";
            case IN_BERARBEITUNG:
                return "in Bearbeitung";
            default:
                return "";
        }
    }
}
