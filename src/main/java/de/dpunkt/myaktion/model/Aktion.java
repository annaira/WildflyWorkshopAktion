package de.dpunkt.myaktion.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@NamedQueries({ @NamedQuery(name = Aktion.findAll, query = "SELECT a FROM Aktion a ORDER BY a.name"),
		@NamedQuery(name = Aktion.getBisherGespendet, query = "SELECT SUM(s.betrag) FROM Spende s WHERE s.aktion = :aktion") })

@Entity
public class Aktion {

	public static final String findAll = "Aktion.findAll";
	public static final String getBisherGespendet = "Aktion.getBisherGespendet";

	private String name;
	private Double spendenZiel;
	private Double spendenBetrag;
	@Transient
	private Double bisherGespendet;
	@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "kontoName")) })
	@Embedded
	private Konto konto;
	@GeneratedValue
	@Id
	private Long id;
	@OneToMany(mappedBy="aktion", cascade=CascadeType.REMOVE)
	private List<Spende> spenden;

	public Aktion() {
		konto = new Konto();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSpendenZiel() {
		return spendenZiel;
	}

	public void setSpendenZiel(Double spendenZiel) {
		this.spendenZiel = spendenZiel;
	}

	public Double getSpendenBetrag() {
		return spendenBetrag;
	}

	public void setSpendenBetrag(Double spendenBetrag) {
		this.spendenBetrag = spendenBetrag;
	}

	public Double getBisherGespendet() {
		return bisherGespendet;
	}

	public void setBisherGespendet(Double bisherGespendet) {
		this.bisherGespendet = bisherGespendet;
	}

	public Konto getKonto() {
		return konto;
	}

	public void setKonto(Konto konto) {
		this.konto = konto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Spende> getSpenden() {
		return spenden;
	}

	public void setSpenden(List<Spende> spenden) {
		this.spenden = spenden;
	}
}
