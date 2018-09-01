package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.model.FormConfig;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@SessionScoped
@Named
public class SpendeFormEditController implements Serializable {

	private static final long serialVersionUID = 6419765374199358664L;

	private FormConfig formConfig;
    private Aktion aktion;

    public String doOk() {
        return Pages.AKTION_LIST;
    }

    public String getUrl() {
        return getAppUrl() + "/" + Pages.GELD_SPENDEN + ".jsf" + "?bgColor=" + formConfig.getBgColor() + "&textColor=" + formConfig.getTextColor() + "&aktionId=" + aktion.getId();
    }

    private String getAppUrl() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
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


}
