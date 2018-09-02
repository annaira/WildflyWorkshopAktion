package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Spende;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

@SessionScoped
@Named
public class GeldSpendenController implements Serializable {

	private static final long serialVersionUID = 5417028731084607094L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Logger logger;

	private String textColor = "000000";
	private String bgColor = "ffffff";

	private String title = "Geld spenden";

	private Spende spende;
	private Long aktionId;

	@PostConstruct
	public void init() {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getAktionId() {
		return aktionId;
	}

	public void setAktionId(Long aktionId) {
		this.aktionId = aktionId;
	}

	public String doSpende() {
		logger.info(spende.getSpenderName() + " hat " + spende.getBetrag() + " Euro gespendet.");
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Vielen Dank für die Spende", null);
		facesContext.addMessage(null, facesMessage);
		init();
		return Pages.GELD_SPENDEN;
	}

}
