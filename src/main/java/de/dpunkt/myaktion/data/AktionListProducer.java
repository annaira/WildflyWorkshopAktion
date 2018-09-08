package de.dpunkt.myaktion.data;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.services.AktionService;
import de.dpunkt.myaktion.util.Events.Added;
import de.dpunkt.myaktion.util.Events.Deleted;
import de.dpunkt.myaktion.util.Events.Updated;
import de.dpunkt.myaktion.util.TecLog;

public class AktionListProducer {

	@Inject
	private AktionService aktionService;

	@Inject
	@TecLog
	private Logger logger;

	private List<Aktion> aktionen;

	@Named
	@Produces
	public List<Aktion> getAktionen() {
		return aktionen;
	}

	@PostConstruct
	public void init() {
		aktionen = aktionService.getAllAktionen();
	}

	public void onAktionAdded(@Observes @Added Aktion aktion) {
		aktionService.addAktion(aktion);
		init();
	}

	public void onAktionDeleted(@Observes @Deleted Aktion aktion) {
		aktionService.deleteAktion(aktion);
		init();
	}

	public void onAktionUpdated(@Observes @Updated Aktion aktion) {
		aktionService.updateAktion(aktion);
		init();
	}
}
