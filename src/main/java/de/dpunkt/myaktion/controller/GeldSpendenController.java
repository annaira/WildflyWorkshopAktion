package de.dpunkt.myaktion.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import de.dpunkt.myaktion.model.Spende;
import de.dpunkt.myaktion.model.Spende.Status;
import de.dpunkt.myaktion.services.SpendeService;
import de.dpunkt.myaktion.util.FachLog;

@SessionScoped
@Named
public class GeldSpendenController implements Serializable {

	private static final long serialVersionUID = 5417028731084607094L;
	
	@Inject
	private SpendeService spendeService;

	@Inject
	private FacesContext facesContext;
	
	@FachLog
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
		addSpende();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Vielen Dank für die Spende", null);
		facesContext.addMessage(null, facesMessage);
		init();
		return Pages.GELD_SPENDEN;
	}

	public void addSpende() {
		getSpende().setStatus(Status.IN_BERARBEITUNG);
		spendeService.addSpende(getAktionId(), getSpende());
		logger.info(spende.getSpenderName() + " hat " + spende.getBetrag() + " Euro gespendet.");
		init();
	}

}
