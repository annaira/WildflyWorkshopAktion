package de.dpunkt.myaktion.services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.util.TecLog;

@Stateless
public class AktionServiceBean implements AktionService {

	@TecLog
	@Inject	
	private Logger logger;

	@Inject
	private EntityManager entityManager;

	@Override
	public List<Aktion> getAllAktionen() {
		logger.info("Entering AktionServiceBean.getAllAktionen()");

		TypedQuery<Aktion> query = entityManager.createNamedQuery(Aktion.findAll, Aktion.class);

		List<Aktion> aktionen = query.getResultList();
		for(Aktion aktion : aktionen ) {
			Double bisherGespendet = getBisherGespendet(aktion);
			aktion.setBisherGespendet(bisherGespendet);
		}
		return aktionen;
	}

	@Override
	public void addAktion(Aktion aktion) {
		entityManager.persist(aktion);
	}

	@Override
	public void deleteAktion(Aktion aktion) {
		Aktion managedAktion = entityManager.find(Aktion.class, aktion.getId());
		entityManager.remove(managedAktion);
	}

	@Override
	public void updateAktion(Aktion aktion) {
		entityManager.merge(aktion);
	}
	
	private Double getBisherGespendet(Aktion aktion) {
		TypedQuery<Double> query = entityManager.createNamedQuery(Aktion.getBisherGespendet, Double.class);
		query.setParameter("aktion", aktion);
		Double result = query.getSingleResult();
		return result == null ? 0d : result;
	}

}
