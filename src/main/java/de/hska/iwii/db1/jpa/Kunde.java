package de.hska.iwii.db1.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "kunde")
public class Kunde {
	@Id
	@Column(name = "kundeID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int kundeID;

	@Column(name = "vorname")
	private String vorname;

	@Column(name = "nachname")
	private String nachname;

	@Column(name = "email")
	private String email;

// Setter und Getter
	public Kunde(String vorname, String nachname, String email) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
	}

	public void setKundeID(int kundeID) { this.kundeID = kundeID; }
	public int getKundeID() { return this.kundeID; }

	public void setVorname(String vorname) { this.vorname = vorname; }
	public String getVorname() { return this.vorname; }

	public void setNachname(String nachname) { this.nachname = nachname; }
	public String getNachname() { return this.nachname; }

	public void setEmail(String email) { this.email = email; }
	public String getEmail() { return this.email; }
}