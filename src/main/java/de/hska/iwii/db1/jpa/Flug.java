package de.hska.iwii.db1.jpa;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "flug")
public class Flug {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nummer")
	private String nummer;

	@Column(name = "flughafen")
	private String flughafen;

	@Column(name = "startzeit")
	@Temporal(TemporalType.TIME)
	private Time startzeit;

// Setter und Getter
	public Flug(String nummer, String flughafen, Time startzeit) {
		this.nummer = nummer;
		this.flughafen = flughafen;
		this.startzeit = startzeit;
	}

	public void setFlughafen(String flughafen) { this.flughafen = flughafen; }
	public String getFlughafen() { return this.flughafen; }

	public void setID(int id) { this.id = id; }
	public int getID() { return this.id; }

	public void setNummer(String nummer) { this.nummer = nummer; }
	public String getNummer() { return this.nummer; }

	public void setStartzeit(Time startzeit) { this.startzeit = startzeit; }
	public Time getStartzeit() { return this.startzeit; }
}