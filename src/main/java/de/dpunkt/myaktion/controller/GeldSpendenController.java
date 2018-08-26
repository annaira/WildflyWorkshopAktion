package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Spende;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class GeldSpendenController implements Serializable {

	private static final long serialVersionUID = 5417028731084607094L;
	
	private String textColor = "000000";
    private String bgColor = "ffffff";
    private Spende spende;
    private Long aktionId;


    public GeldSpendenController() {
        this.spende = new Spende();
    }

    public Spende getSpende() {
        return spende;
    }

    public void setSpende(Spende spende) {
        this.spende = spende;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }


    public Long getAktionId() {
        return aktionId;
    }

    public void setAktionId(Long aktionId) {
        this.aktionId = aktionId;
    }

    public String doSpende() {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Vielen Dank für die Spende", null);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        this.spende = new Spende();

        return Pages.GELD_SPENDEN;
    }

}
