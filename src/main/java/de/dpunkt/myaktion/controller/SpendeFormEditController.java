package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.model.FormConfig;

@SessionScoped
@Named
public class SpendeFormEditController implements Serializable {

	private static final long serialVersionUID = 6419765374199358664L;

	@Inject
	private HttpServletRequest request;

	private FormConfig formConfig;
	private Aktion aktion;

	public SpendeFormEditController() {
		formConfig = new FormConfig();
	}

	public String doOk() {
		return Pages.AKTION_LIST;
	}

	public String getUrl() {
		return getAppUrl() + "/" + Pages.GELD_SPENDEN + ".jsf" + "?bgColor=" + formConfig.getBgColor() + "&textColor="
				+ formConfig.getTextColor() + "&title=" + formConfig.getTitle() + "&aktionId=" + aktion.getId();
	}

	private String getAppUrl() {
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String contextPath = request.getContextPath();
		return scheme + "://" + serverName + ":" + serverPort + contextPath;
	}

	public Aktion getAktion() {
		return aktion;
	}

	public void setAktion(Aktion aktion) {
		this.aktion = aktion;
	}

	public FormConfig getFormConfig() {
		return formConfig;
	}

	public void setFormConfig(FormConfig formConfig) {
		this.formConfig = formConfig;
	}

}
